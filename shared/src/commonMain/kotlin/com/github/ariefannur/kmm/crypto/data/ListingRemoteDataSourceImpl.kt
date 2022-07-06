package com.github.ariefannur.kmm.crypto.data

import com.github.ariefannur.kmm.crypto.data.response.ListingResult
import com.github.ariefannur.kmm.crypto.domain.abstract.ListingRemoteDataSource
import com.github.ariefannur.kmm.crypto.model.Coin
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ListingRemoteDataSourceImpl(
    private val client: HttpClient
): ListingRemoteDataSource {

    override suspend fun requestGetListingLatest(): List<Coin> {
        val response = client.get(GET_LISTING_PATH) {
            headers {  append("X-CMC_PRO_API_KEY", "722af30a-8002-42bc-8444-0d11ae7e4d79") }
        }
        if (response.status == HttpStatusCode.OK) {
            return response.body<ListingResult>().data.map {
                Coin(it.name, it.symbol, it.slug, it.num_market_pairs)
            }
        } else throw Exception(response.status.description)
    }
}