package com.example.cryptoapp.data

import com.example.cryptoapp.data.local.CoinInfoDbModel
import com.example.cryptoapp.data.remote.api.ApiFactory
import com.example.cryptoapp.data.remote.dto.DataItemDto
import com.example.cryptoapp.data.remote.dto.TopCoinsResponseDto
import com.example.cryptoapp.domain.entity.CoinInfo
import com.example.cryptoapp.domain.entity.CoinPriceInfo
import com.example.cryptoapp.utils.convertTimestampToTime

class CoinInfoMapper {
/*    fun entityToDbModel(entity: CoinInfo): CoinInfoDbModel {
        return CoinInfoDbModel(
            id = entity.id,
            name = entity.name,
            imageUrl = entity.imageUrl,
            price = entity.priceInfo.price,
            fromSymbol = entity.priceInfo.fromSymbol,
            toSymbol = entity.priceInfo.toSymbol,
            lastUpdate = entity.priceInfo.lastUpdate,
            lowDay = entity.priceInfo.lowDay,
            highDay = entity.priceInfo.highDay,
            lastMarket = entity.priceInfo.lastMarket
        )
    }*/

    fun dbModelToEntity(dbModel: CoinInfoDbModel): CoinInfo {
        return CoinInfo(
            id = dbModel.id,
            name = dbModel.name ?: "",
            fullImageUrl = getFullImageUrl(dbModel.imageUrl ?: ""),
            priceInfo = CoinPriceInfo(
                price = dbModel.price ?: "",
                fromSymbol = dbModel.fromSymbol ?: "",
                toSymbol = dbModel.toSymbol,
                lastUpdate = getFormattedTime(dbModel.lastUpdate),
                lowDay = dbModel.lowDay,
                highDay = dbModel.highDay,
                lastMarket = dbModel.lastMarket
            )
        )
    }

    fun mapListDbModelToListEntity(list: List<CoinInfoDbModel>) = list.map {
        dbModelToEntity(it)
    }

    fun dataDtoToDbModel(dto: DataItemDto): CoinInfoDbModel {
        return CoinInfoDbModel(
            id = dto.coinInfo.id.toInt(),
            name = dto.coinInfo.name,
            imageUrl = dto.coinInfo.imageUrl,
            price = dto.raw.usd.price,
            fromSymbol = dto.raw.usd.fromSymbol,
            toSymbol = dto.raw.usd.toSymbol,
            lastUpdate = dto.raw.usd.lastUpdate,
            lowDay = dto.raw.usd.lowDay,
            highDay = dto.raw.usd.highDay,
            lastMarket = dto.raw.usd.lastMarket
        )
    }

    private fun getFullImageUrl(imageUrl: String): String {
        return if (imageUrl.isBlank()) "" else ApiFactory.BASE_IMAGE_URL + imageUrl
    }

    private fun getFormattedTime(lastUpdate: Long?): String {
        return if (lastUpdate == null) "" else convertTimestampToTime(lastUpdate)
    }
}