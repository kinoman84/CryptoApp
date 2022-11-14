package com.example.cryptoapp.presentation.coininfo

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.CoinMockRepositoryImpl

class CoinDetailsViewModel: ViewModel() {

    private val repository = CoinMockRepositoryImpl()

    fun getCoinDetails(coinId: Int) = repository.getCoinInfo(coinId)
}