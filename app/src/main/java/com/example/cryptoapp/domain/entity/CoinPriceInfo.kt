package com.example.cryptoapp.domain.entity

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

data class CoinPriceInfo(
    val price: String,
    val fromSymbol: String,
    val toSymbol: String?,
    val lastUpdate: Long?
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    //TODO: Почему не работает использование утилиты?
    fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }
}