package com.example.cryptoapp.presentation.coinlist

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.CoinMockRepositoryImpl
import com.example.cryptoapp.domain.usecase.GetCoinListUseCase

class CoinListViewModel: ViewModel() {

    private val repository = CoinMockRepositoryImpl()

    private val getCoinListUseCase = GetCoinListUseCase(repository)

    val coinList = getCoinListUseCase.getCoinList()

}