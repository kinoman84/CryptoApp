package com.example.cryptoapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.entity.CoinInfo

interface CoinRepository {
    fun getCoinList() : LiveData<List<CoinInfo>>
    fun getCoinInfo(id: Int) : LiveData<CoinInfo>
    suspend fun refreshData()
}