package com.github.ariefannur.kmm.crypto.model

data class Coin (
        val id: Int,
        val name: String,
        val symbol: String,
        val slug: String,
        val price: Double,
        val marketCap: Double,
        val imgLogo: String
        )