package com.example.cryptoapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopCoinsResponseDto(
    @SerialName("Data")
    val dataList : List<DataItemDto>
)
