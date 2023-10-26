package com.github.ariefannur.kmm.crypto.common

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.surrus.peopleinspace.db.CryptoDatabase
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import org.koin.dsl.module

actual fun platformModule() = module {
    single<HttpClientEngine> { Android.create() }
    single { DatabaseDriverFactory(get()) }
}

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(CryptoDatabase.Schema, context, "crypto.db")
    }
}