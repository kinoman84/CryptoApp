package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.repository.CoinRepository

class RefreshDataUseCase(private val repository: CoinRepository) {

    suspend fun refreshData() {
        repository.refreshData()
    }
}