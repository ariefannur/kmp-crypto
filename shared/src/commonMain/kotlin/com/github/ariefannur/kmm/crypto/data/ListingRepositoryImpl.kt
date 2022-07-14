package com.github.ariefannur.kmm.crypto.data

import com.github.ariefannur.kmm.crypto.domain.abstract.ListingLocalDataSource
import com.github.ariefannur.kmm.crypto.domain.abstract.ListingRemoteDataSource
import com.github.ariefannur.kmm.crypto.domain.abstract.ListingRepository
import com.github.ariefannur.kmm.crypto.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListingRepositoryImpl(
    private val remote: ListingRemoteDataSource,
    private val local: ListingLocalDataSource
): ListingRepository {

    override suspend fun getListingLatest(): Flow<List<Coin>> = flow {
        with(local.getListingLatest()) {
            if (!this.isNullOrEmpty()) {
                emit(this)
            }
        }

        with(remote.requestGetListingLatest()) {
            if (this.isNotEmpty()) {
                emit(this)
                local.cacheListLatest(this)
            }
        }
    }
}