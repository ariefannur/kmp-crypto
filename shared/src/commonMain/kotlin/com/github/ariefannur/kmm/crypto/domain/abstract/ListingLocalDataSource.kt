package com.github.ariefannur.kmm.crypto.domain.abstract

import com.github.ariefannur.kmm.crypto.model.Coin

interface ListingLocalDataSource {
    suspend fun getListingLatest(): List<Coin>
    suspend fun cacheListLatest(data: List<Coin>)
}