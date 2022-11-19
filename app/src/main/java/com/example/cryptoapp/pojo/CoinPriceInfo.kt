package com.example.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.utils.convertTimestampToTime
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String?,
    @SerializedName("MARKET")
    @Expose
    val market: String?,
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,
    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String?,
    @SerializedName("FLAGS")
    @Expose
    val flags: String?,
    @SerializedName("PRICE")
    @Expose
    val price: String?,
    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long?,
    @SerializedName("LASTVOLUME")
    @Expose
    val lastVolume: String?,
    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastVolumeTo: String?,
    @SerializedName("LASTTRADEID")
    @Expose
    val lastTradeId: String?,
    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeDay: String?,
    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumeDayTo: String?,
    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24Hour: String?,
    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24HourTo: String?,
    @SerializedName("OPENDAY")
    @Expose
    val openDay: String?,
    @SerializedName("HIGHDAY")
    @Expose
    val highDay: String?,
    @SerializedName("LOWDAY")
    @Expose
    val lowDay: String?,
    @SerializedName("OPEN24HOUR")
    @Expose
    val open24Hour: String?,
    @SerializedName("HIGH24HOUR")
    @Expose
    val high24Hour: String?,
    @SerializedName("LOW24HOUR")
    @Expose
    val low24Hour: String?,
    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String?,
    @SerializedName("VOLUMEHOUR")
    @Expose
    val volumeHour: String?,
    @SerializedName("VOLUMEHOURTO")
    @Expose
    val volumeHourTo: String?,
    @SerializedName("OPENHOUR")
    @Expose
    val openHour: String?,
    @SerializedName("HIGHHOUR")
    @Expose
    val highHour: String?,
    @SerializedName("LOWHOUR")
    @Expose
    val lowHour: String?,
    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val topTierVolume24Hour: String?,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val topTierVolume24HourTo: String?,
    @SerializedName("CHANGE24HOUR")
    @Expose
    val change24Hour: String?,
    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    val changePCT24Hour: String?,
    @SerializedName("CHANGEDAY")
    @Expose
    val changeDay: String?,
    @SerializedName("CHANGEPCTDAY")
    @Expose
    val changePCTDay: String?,
    @SerializedName("SUPPLY")
    @Expose
    val supply: String?,
    @SerializedName("MKTCAP")
    @Expose
    val mktCap: String?,
    @SerializedName("TOTALVOLUME24H")
    @Expose
    val totalVolume24Hour: String?,
    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    val totalVolume24HourTo: String?,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    val totalTopTierVolume24Hour: String?,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    val totalTopTierVolume24HourTo: String?,
    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String?
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl(): String {
        return BASE_IMAGE_URL + imageUrl
    }
}

/*

{
    "Message": "Success",
    "Type": 100,
    "MetaData": {
        "Count": 3249
    },
    "SponsoredData": [],
    "Data": [
        {
            "CoinInfo": {
                "Id": "1182",
                "Name": "BTC",
                "FullName": "Bitcoin",
                "Internal": "BTC",
                "ImageUrl": "/media/37746251/btc.png",
                "Url": "/coins/btc/overview",
                "Algorithm": "SHA-256",
                "ProofType": "PoW",
                "Rating": {
                    "Weiss": {
                        "Rating": "B+",
                        "TechnologyAdoptionRating": "A-",
                        "MarketPerformanceRating": "D"
                    }
                },
                "NetHashesPerSecond": 270827515702170850000,
                "BlockNumber": 763831,
                "BlockTime": 575,
                "BlockReward": 6.25,
                "AssetLaunchDate": "2009-01-03",
                "MaxSupply": 20999999.9769,
                "Type": 1,
                "DocumentType": "Webpagecoinp"
            },
            "RAW": {
                "USD": {
                    "TYPE": "5",
                    "MARKET": "CCCAGG",
                    "FROMSYMBOL": "BTC",
                    "TOSYMBOL": "USD",
                    "FLAGS": "2050",
                    "PRICE": 16613.83,
                    "LASTUPDATE": 1668852226,
                    "MEDIAN": 16622.5,
                    "LASTVOLUME": 0.00802662,
                    "LASTVOLUMETO": 133.3364455836,
                    "LASTTRADEID": "457706996",
                    "VOLUMEDAY": 7109.283411701623,
                    "VOLUMEDAYTO": 118052632.30270532,
                    "VOLUME24HOUR": 32955.59583956,
                    "VOLUME24HOURTO": 548325833.636374,
                    "OPENDAY": 16677.88,
                    "HIGHDAY": 16686.87,
                    "LOWDAY": 16539.01,
                    "OPEN24HOUR": 16751.61,
                    "HIGH24HOUR": 16801.62,
                    "LOW24HOUR": 16527.8,
                    "LASTMARKET": "Coinbase",
                    "VOLUMEHOUR": 26.208764570000014,
                    "VOLUMEHOURTO": 435482.83442463237,
                    "OPENHOUR": 16614,
                    "HIGHHOUR": 16618.51,
                    "LOWHOUR": 16613.25,
                    "TOPTIERVOLUME24HOUR": 32955.59583956,
                    "TOPTIERVOLUME24HOURTO": 548325833.636374,
                    "CHANGE24HOUR": -137.77999999999884,
                    "CHANGEPCT24HOUR": -0.8224881071132794,
                    "CHANGEDAY": -64.04999999999927,
                    "CHANGEPCTDAY": -0.3840416168002124,
                    "CHANGEHOUR": -0.16999999999825377,
                    "CHANGEPCTHOUR": -0.0010232334175891043,
                    "CONVERSIONTYPE": "direct",
                    "CONVERSIONSYMBOL": "",
                    "SUPPLY": 19211450,
                    "MKTCAP": 319175764353.50006,
                    "MKTCAPPENALTY": 0,
                    "CIRCULATINGSUPPLY": 19211450,
                    "CIRCULATINGSUPPLYMKTCAP": 319175764353.50006,
                    "TOTALVOLUME24H": 316173.5297346056,
                    "TOTALVOLUME24HTO": 5253660440.319899,
                    "TOTALTOPTIERVOLUME24H": 315739.19266308635,
                    "TOTALTOPTIERVOLUME24HTO": 5246444438.0509815,
                    "IMAGEURL": "/media/37746251/btc.png"
                }
            },
            "DISPLAY": {
                "USD": {
                    "FROMSYMBOL": "Ƀ",
                    "TOSYMBOL": "$",
                    "MARKET": "CryptoCompare Index",
                    "PRICE": "$ 16,613.8",
                    "LASTUPDATE": "Just now",
                    "LASTVOLUME": "Ƀ 0.008027",
                    "LASTVOLUMETO": "$ 133.34",
                    "LASTTRADEID": "457706996",
                    "VOLUMEDAY": "Ƀ 7,109.28",
                    "VOLUMEDAYTO": "$ 118,052,632.3",
                    "VOLUME24HOUR": "Ƀ 32,955.6",
                    "VOLUME24HOURTO": "$ 548,325,833.6",
                    "OPENDAY": "$ 16,677.9",
                    "HIGHDAY": "$ 16,686.9",
                    "LOWDAY": "$ 16,539.0",
                    "OPEN24HOUR": "$ 16,751.6",
                    "HIGH24HOUR": "$ 16,801.6",
                    "LOW24HOUR": "$ 16,527.8",
                    "LASTMARKET": "Coinbase",
                    "VOLUMEHOUR": "Ƀ 26.21",
                    "VOLUMEHOURTO": "$ 435,482.8",
                    "OPENHOUR": "$ 16,614.0",
                    "HIGHHOUR": "$ 16,618.5",
                    "LOWHOUR": "$ 16,613.3",
                    "TOPTIERVOLUME24HOUR": "Ƀ 32,955.6",
                    "TOPTIERVOLUME24HOURTO": "$ 548,325,833.6",
                    "CHANGE24HOUR": "$ -137.78",
                    "CHANGEPCT24HOUR": "-0.82",
                    "CHANGEDAY": "$ -64.05",
                    "CHANGEPCTDAY": "-0.38",
                    "CHANGEHOUR": "$ -0.17",
                    "CHANGEPCTHOUR": "0.00",
                    "CONVERSIONTYPE": "direct",
                    "CONVERSIONSYMBOL": "",
                    "SUPPLY": "Ƀ 19,211,450.0",
                    "MKTCAP": "$ 319.18 B",
                    "MKTCAPPENALTY": "0 %",
                    "CIRCULATINGSUPPLY": "Ƀ 19,211,450.0",
                    "CIRCULATINGSUPPLYMKTCAP": "$ 319.18 B",
                    "TOTALVOLUME24H": "Ƀ 316.17 K",
                    "TOTALVOLUME24HTO": "$ 5.25 B",
                    "TOTALTOPTIERVOLUME24H": "Ƀ 315.74 K",
                    "TOTALTOPTIERVOLUME24HTO": "$ 5.25 B",
                    "IMAGEURL": "/media/37746251/btc.png"
                }
            }
        },
 */