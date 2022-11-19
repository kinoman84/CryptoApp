package com.example.cryptoapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RawDto(
    @SerialName("USD") val usd: UsdDto
)

@Serializable
data class UsdDto(
    @SerialName("PRICE") val price: String,
    @SerialName("FROMSYMBOL") val fromSymbol: String,
    @SerialName("TOSYMBOL") val toSymbol: String?,
    @SerialName("LASTUPDATE") val lastUpdate: Long?,
    @SerialName("LOWDAY") val lowDay: String?,
    @SerialName("HIGHDAY") val highDay: String?,
    @SerialName("LASTMARKET") val lastMarket: String?
)