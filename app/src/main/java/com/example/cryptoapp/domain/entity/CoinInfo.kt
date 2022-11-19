package com.example.cryptoapp.domain.entity

import com.example.cryptoapp.data.remote.api.ApiFactory

data class CoinInfo(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val priceInfo: CoinPriceInfo
) {
    fun getFullImageUrl(): String {
        return ApiFactory.BASE_IMAGE_URL + imageUrl
    }
}