package com.example.cryptoapp.data.remote

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.cryptoapp.data.CoinRepositoryImpl
import kotlinx.coroutines.*

class CoinInfoWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {

    val application = context as Application
    val repository = CoinRepositoryImpl(application)

    val scope = CoroutineScope(Dispatchers.IO)

    override fun doWork(): Result {

        while (true) {
            Thread.sleep(10000)
            scope.launch {
                Log.d("worker", "launch")
                repository.refreshData()
            }
        }
    }

    override fun onStopped() {
        super.onStopped()
        scope.cancel()
    }

    companion object {
        const val NAME = "refresher"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<CoinInfoWorker>()
                .build()
        }
    }
}