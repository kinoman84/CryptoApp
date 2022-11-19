package com.example.cryptoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_full_info")
data class CoinInfoDbModel(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val imageUrl: String?,
    val price: String?,
    val fromSymbol: String?,
    val toSymbol: String?,
    val lastUpdate: Long?,
    val lowDay: String?,
    val highDay: String?,
    val lastMarket: String?
)