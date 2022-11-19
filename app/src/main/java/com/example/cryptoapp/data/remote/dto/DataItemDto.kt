package com.example.cryptoapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataItemDto(
    @SerialName("CoinInfo") val coinInfo: CoinInfoDto,
    @SerialName("RAW") val raw: RawDto
)
