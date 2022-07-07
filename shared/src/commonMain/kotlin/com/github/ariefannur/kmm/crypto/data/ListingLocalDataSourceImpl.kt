package com.github.ariefannur.kmm.crypto.data.response

import com.github.ariefannur.kmm.crypto.domain.abstract.ListingLocalDataSource
import com.github.ariefannur.kmm.crypto.model.Coin

class ListingLocalDataSourceImpl: ListingLocalDataSource {

    override suspend fun getListingLatest(): List<Coin> {
        TODO("Not yet implemented")
    }

    override suspend fun cacheListLatest(data: List<Coin>) {
        TODO("Not yet implemented")
    }
}