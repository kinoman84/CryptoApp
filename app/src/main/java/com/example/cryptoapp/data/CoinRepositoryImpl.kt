package com.example.cryptoapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.cryptoapp.data.local.AppDatabase
import com.example.cryptoapp.data.remote.RemoteMockStorage
import com.example.cryptoapp.domain.entity.CoinInfo
import com.example.cryptoapp.domain.entity.CoinPriceInfo
import com.example.cryptoapp.domain.repository.CoinRepository

class CoinRepositoryImpl(application: Application) : CoinRepository {

    private val localSource = AppDatabase.getInstance(application).coinInfoDao()
    private val remoteSource = RemoteMockStorage()
    private val mapper = CoinInfoMapper()

    init {
        refreshData()
    }

    override fun getCoinList(): LiveData<List<CoinInfo>> {
        return Transformations.map(localSource.getPriceList()) { coinInfoDbModelList ->
            mapper.mapListDbModelToListEntity(coinInfoDbModelList)
        }
    }

    override fun getCoinInfo(id: Int): LiveData<CoinInfo> {
        TODO("Not yet implemented")
    }

    override fun refreshData() {
        val list = remoteSource.getCoinList().map {
            mapper.entityToDbModel(it)
        }
        localSource.insertPriceList(list)
    }
}