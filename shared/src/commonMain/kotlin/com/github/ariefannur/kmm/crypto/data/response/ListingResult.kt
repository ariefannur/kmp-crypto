package com.github.ariefannur.kmm.crypto.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListingResult (val data: List<CoinResult>)

@Serializable
data class CoinResult(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("quote")
    val quote: Quote
)
@Serializable
data class Quote (
    @SerialName("USD")
    val USD: Currency)
@Serializable
data class Currency (
    @SerialName("price")
    val price: Double,
    @SerialName("market_cap")
    val marketCap: Double)