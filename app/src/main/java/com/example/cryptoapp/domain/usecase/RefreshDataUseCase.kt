package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.repository.CoinRepository

class RefreshDataUseCase(private val repository: CoinRepository) {

    fun refreshData() {
        repository.refreshData()
    }
}