package com.github.ariefannur.kmm.crypto.domain.abstract

import com.github.ariefannur.kmm.crypto.model.Coin
import kotlinx.coroutines.flow.Flow

interface ListingRepository {
    suspend fun getListingLatest(): Flow<List<Coin>>
}