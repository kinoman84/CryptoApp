package com.example.cryptoapp.data.remote

import com.example.cryptoapp.domain.entity.CoinInfo
import com.example.cryptoapp.domain.entity.CoinPriceInfo

class RemoteMockStorage {

    private var coinList = listOf(
            CoinInfo(
                1182,
                "BTC",
                "/media/37746251/btc.png",
                CoinPriceInfo(
                    "16547.22",
                    "BTC",
                    "USD",
                    1668355635,
                    "16509.15",
                    "17091.76",
                    "Kraken"
                )
            ),
            CoinInfo(
                7605,
                "ETH",
                "/media/37746238/eth.png",
                CoinPriceInfo(
                    "1228.62",
                    "ETH",
                    "USD",
                    1668355636,
                    "1234.46",
                    "1288.55",
                    "Coinbase"
                )
            )
        )

    fun getCoinList(): List<CoinInfo> {
        return coinList
    }
}