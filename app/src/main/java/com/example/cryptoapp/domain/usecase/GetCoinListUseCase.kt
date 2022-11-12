package com.example.cryptoapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.entity.CoinInfo
import com.example.cryptoapp.domain.repository.CoinRepository

class GetCoinListUseCase(private val repository: CoinRepository) {

    fun getCoinList(): LiveData<List<CoinInfo>> {
        return repository.getCoinList()
    }
}