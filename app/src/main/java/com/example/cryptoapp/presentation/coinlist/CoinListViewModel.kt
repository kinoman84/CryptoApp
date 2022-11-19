package com.example.cryptoapp.presentation.coinlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.CoinRepositoryImpl
import com.example.cryptoapp.domain.usecase.GetCoinListUseCase
import com.example.cryptoapp.domain.usecase.RefreshDataUseCase
import kotlinx.coroutines.launch

class CoinListViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinListUseCase = GetCoinListUseCase(repository)
    private val refreshDataUseCase = RefreshDataUseCase(repository)
    val coinList = getCoinListUseCase.getCoinList()

    init {
        viewModelScope.launch {
            refreshDataUseCase.refreshData()
        }
    }

}