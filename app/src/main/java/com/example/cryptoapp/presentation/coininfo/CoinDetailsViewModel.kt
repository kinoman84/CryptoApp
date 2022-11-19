package com.example.cryptoapp.presentation.coininfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.CoinRepositoryImpl
import com.example.cryptoapp.data.remote.RemoteMockStorage

class CoinDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    fun getCoinDetails(coinId: Int) = repository.getCoinInfo(coinId)
}