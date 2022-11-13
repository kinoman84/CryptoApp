package com.example.cryptoapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cryptoapp.domain.entity.CoinInfo
import com.example.cryptoapp.domain.entity.CoinPriceInfo
import com.example.cryptoapp.domain.repository.CoinRepository

class CoinMockRepositoryImpl : CoinRepository {

    private val _coinLiveData = MutableLiveData<List<CoinInfo>>()
    private val coinLiveData get() = _coinLiveData

    init {
        _coinLiveData.value = listOf(
            CoinInfo(
                1182,
                "BTC",
                "/media/37746251/btc.png",
                CoinPriceInfo(
                    "16547.22",
                    "BTC",
                    "USD",
                    1668355635
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
                    1668355636
                )
            )
        )
    }

    override fun getCoinList(): LiveData<List<CoinInfo>> {
        return coinLiveData
    }

    override fun getCoinInfo(id: Int): LiveData<CoinInfo> {
        TODO("Not yet implemented")
    }

    override fun refreshData() {
        TODO("Not yet implemented")
    }

}