package com.example.cryptoapp.data

import com.example.cryptoapp.data.local.CoinInfoDbModel
import com.example.cryptoapp.domain.entity.CoinInfo
import com.example.cryptoapp.domain.entity.CoinPriceInfo

class CoinInfoMapper {
    fun entityToDbModel (entity: CoinInfo): CoinInfoDbModel {
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
    }

    fun dbModelToEntity (dbModel: CoinInfoDbModel) : CoinInfo {
        return CoinInfo(
            id = dbModel.id,
            name = dbModel.name ?: "",
            imageUrl = dbModel.imageUrl ?: "",
            priceInfo = CoinPriceInfo(
                price = dbModel.price ?: "",
                fromSymbol = dbModel.fromSymbol ?: "",
                toSymbol = dbModel.toSymbol,
                lastUpdate = dbModel.lastUpdate,
                lowDay = dbModel.lowDay,
                highDay = dbModel.highDay,
                lastMarket = dbModel.lastMarket
            )
        )
    }

    fun mapListDbModelToListEntity(list: List<CoinInfoDbModel>) = list.map {
        dbModelToEntity(it)
    }
}