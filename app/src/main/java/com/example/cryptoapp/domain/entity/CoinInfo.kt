package com.example.cryptoapp.domain.entity

import com.example.cryptoapp.api.ApiFactory

data class CoinInfo(
    val id: Int,
    val name: String,
    val urlImage: String,
    val priceInfo: CoinPriceInfo
) {
    fun getFullImageUrl(): String {
        return ApiFactory.BASE_IMAGE_URL + urlImage
    }
}