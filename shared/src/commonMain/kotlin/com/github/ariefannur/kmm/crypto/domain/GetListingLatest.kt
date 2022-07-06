package com.github.ariefannur.kmm.crypto.domain

import com.github.ariefannur.kmm.crypto.domain.abstract.ListingRepository
import com.github.ariefannur.kmm.crypto.domain.base.UseCase
import com.github.ariefannur.kmm.crypto.model.Coin
import kotlinx.coroutines.flow.Flow

class GetListingLatest(private val repository: ListingRepository) : UseCase<List<Coin>, String>(){
    override suspend fun run(params: String): Flow<List<Coin>> {
       return repository.getListingLatest()
    }
}