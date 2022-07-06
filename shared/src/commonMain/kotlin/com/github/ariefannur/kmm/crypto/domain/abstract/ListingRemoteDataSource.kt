package com.github.ariefannur.kmm.crypto.domain.abstract

import com.github.ariefannur.kmm.crypto.model.Coin

interface ListingRemoteDataSource {
    suspend fun requestGetListingLatest(): List<Coin>
}