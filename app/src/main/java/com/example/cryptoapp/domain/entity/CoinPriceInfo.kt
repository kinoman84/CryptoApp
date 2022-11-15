package com.example.cryptoapp.domain.entity

import com.example.cryptoapp.utils.convertTimestampToTime

data class CoinPriceInfo(
    //PRICE
    val price: String,
    //FROMSYMBOL
    val fromSymbol: String,
    //TOSYMBOL
    val toSymbol: String?,
    //LASTUPDATE
    val lastUpdate: Long?,
    //LOWDAY
    val lowDay: String?,
    //HIGHDAY
    val highDay: String?,
    //LASTMARKET
    val lastMarket: String?
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }
}