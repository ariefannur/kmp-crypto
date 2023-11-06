package com.github.ariefannur.kmm.crypto.common

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.surrus.peopleinspace.db.CryptoDatabase
import io.ktor.client.engine.darwin.*
import org.koin.dsl.module
import kotlin.math.round

actual fun platformModule() = module {
    single { Darwin.create() }
    single { DatabaseDriverFactory() }
}

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(CryptoDatabase.Schema, "crypto.db")
    }
}

actual fun roundOffDecimal(value: Double): Double {
    return round(value * 100) / 100.0
}