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
        val imageLogo = "https://s2.coinmarketcap.com/static/img/coins/64x64/"

        if (response.status == HttpStatusCode.OK) {
            return response.body<ListingResult>().data.map {
                Coin(it.id, it.name.orEmpty(), it.symbol.orEmpty(), it.slug.orEmpty(),
                    it.quote?.USD?.price ?: 0.0, it.quote?.USD?.marketCap ?: 0.0,
                    it.quote?.USD?.volumeChange24 ?: 0.0, imageLogo + it.id + ".png").apply {
                    percentage = this.move24 / this.price
                }
            }
        } else {
            println("Error GET ${response.status.description} ::")
            throw Exception(response.status.description)
        }
    }
}