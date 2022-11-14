package com.example.cryptoapp.domain.entity

import com.example.cryptoapp.utils.convertTimestampToTime

data class CoinPriceInfo(
    val price: String,
    val fromSymbol: String,
    val toSymbol: String?,
    val lastUpdate: Long?
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }
}