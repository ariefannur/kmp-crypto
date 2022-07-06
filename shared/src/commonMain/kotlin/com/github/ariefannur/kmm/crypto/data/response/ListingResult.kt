package com.github.ariefannur.kmm.crypto.data.response

import kotlinx.serialization.Serializable

@Serializable
data class ListingResult (val data: List<CoinResult>)

@Serializable
data class CoinResult(
    val name: String,
    val symbol: String,
    val slug: String,
    val num_market_pairs: Int
)