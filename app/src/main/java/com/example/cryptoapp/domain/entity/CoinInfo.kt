package com.example.cryptoapp.domain.entity

data class CoinInfo(
    val id: Int,
    val name: String,
    val urlImage: String,
    val priceInfo: CoinPriceInfo
)