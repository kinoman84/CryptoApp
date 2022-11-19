package com.example.cryptoapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinInfoDto(
    @SerialName("Id") val id: String,
    @SerialName("Name") val name: String,
    @SerialName("ImageUrl") val imageUrl: String
)