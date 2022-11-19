package com.example.cryptoapp.presentation.coinlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.CoinRepositoryImpl
import com.example.cryptoapp.data.remote.RemoteMockStorage
import com.example.cryptoapp.domain.usecase.GetCoinListUseCase
import kotlinx.coroutines.coroutineScope

class CoinListViewModel(application: Application): AndroidViewModel(application) {


    private val repository = CoinRepositoryImpl(application)

    private val getCoinListUseCase = GetCoinListUseCase(repository)

    init {

    }

    val coinList = getCoinListUseCase.getCoinList()

}