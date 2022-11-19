package com.example.cryptoapp.presentation.coininfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.data.CoinRepositoryImpl
import com.example.cryptoapp.domain.usecase.GetCoinInfoUseCase

class CoinDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)
    private val getCoinInUseCase = GetCoinInfoUseCase(repository)

    fun getCoinDetails(coinId: Int) = getCoinInUseCase.getCoinInfo(coinId)
}