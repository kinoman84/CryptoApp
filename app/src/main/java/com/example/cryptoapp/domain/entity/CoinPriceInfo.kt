package com.example.cryptoapp.domain.entity

data class CoinPriceInfo(
    val price: String,
    val fromSymbol: String,
    val toSymbol: String?,
    val lastUpdate: String?,
    val lowDay: String?,
    val highDay: String?,
    val lastMarket: String?
)