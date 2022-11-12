package com.example.cryptoapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.entity.CoinInfo
import com.example.cryptoapp.domain.repository.CoinRepository

class GetCoinInfoUseCase(private val repository: CoinRepository) {

    fun getCoinInfo(id: Int): LiveData<CoinInfo> {
        return repository.getCoinInfo(id)
    }
}