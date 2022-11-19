package com.example.cryptoapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CoinInfoDao {
    @Query("SELECT * FROM coin_full_info ORDER BY lastUpdate DESC")
    fun getCoinList(): LiveData<List<CoinInfoDbModel>>

    @Query("SELECT * FROM coin_full_info WHERE id == :id LIMIT 1")
    fun getCoinInfo(id: Int): LiveData<CoinInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceList(priceList: List<CoinInfoDbModel>)
}