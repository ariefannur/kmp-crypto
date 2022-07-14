package com.github.ariefannur.kmm.crypto.data

import com.github.ariefannur.kmm.crypto.domain.abstract.ListingLocalDataSource
import com.github.ariefannur.kmm.crypto.model.Coin

class ListingLocalDataSourceImpl(private val db: Database): ListingLocalDataSource {

    override suspend fun getListingLatest(): List<Coin> {
        return db.database.cryptoQueries.selectAll(::mapCoins).executeAsList()
    }

    private fun mapCoins(
        id: Long, name: String,
        symbol: String?, slug: String?,
        price: Double?, marketCap: Double?,
        logo: String?): Coin {
        return Coin(id.toInt(), name, symbol.orEmpty(), slug.orEmpty(), price ?: 0.0, marketCap ?: 0.0, logo.orEmpty())
    }

    override suspend fun cacheListLatest(data: List<Coin>) {
        data.map {  coin ->
            kotlin.runCatching {
                db.database.cryptoQueries.insertCoin(
                    coin.id.toLong(),
                    coin.name,
                    coin.symbol,
                    coin.slug,
                    coin.price,
                    coin.marketCap,
                    coin.imgLogo
                )
            }
        }
    }
}