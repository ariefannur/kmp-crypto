package com.github.ariefannur.kmm.crypto.data

import com.github.ariefannur.kmm.crypto.common.DatabaseDriverFactory
import com.surrus.peopleinspace.db.CryptoDatabase

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    val database = CryptoDatabase(databaseDriverFactory.createDriver())
    val dbQuery = database.cryptoQueries
}