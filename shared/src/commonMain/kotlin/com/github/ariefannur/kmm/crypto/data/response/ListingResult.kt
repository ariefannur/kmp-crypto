package com.github.ariefannur.kmm.crypto.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListingResult (
    @SerialName("status") val status: Status,
    @SerialName("data") val data: List<CoinResult>
)

@Serializable
data class Status(
    @SerialName("timestamp") val timestamp: String,
    @SerialName("error_code") val errorCode: Int,
    @SerialName("error_message") val errorMessage: String?,
    @SerialName("elapsed") val elapsed: Int?,
    @SerialName("credit_count") val creditCount: Int?,
    @SerialName("notice") val notice: String?,
    @SerialName("total_count") val totalCount: Int?,
)

@Serializable
data class CoinResult(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String?,
    @SerialName("symbol")
    val symbol: String?,
    @SerialName("slug")
    val slug: String?,
    @SerialName("num_market_pairs")
    val numMarketPairs: String?,
    @SerialName("date_added")
    val dateAdded: String?,
    @SerialName("tags")
    val tags: List<String>? = listOf(),
    @SerialName("quote")
    val quote: Quote?

    )
@Serializable
data class Quote (
    @SerialName("USD")
    val USD: Currency?)
@Serializable
data class Currency (
    @SerialName("price")
    val price: Double?,
    @SerialName("market_cap")
    val marketCap: Double?,
    @SerialName("volume_24h")
    val volume: Double?,
    @SerialName("volume_change_24h")
    val volumeChange24: Double?)