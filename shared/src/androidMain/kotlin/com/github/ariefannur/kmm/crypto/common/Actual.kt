package com.github.ariefannur.kmm.crypto.common

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.surrus.peopleinspace.db.CryptoDatabase
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import org.koin.dsl.module
import java.math.RoundingMode
import java.text.DecimalFormat

actual fun platformModule() = module {
    single<HttpClientEngine> { Android.create() }
    single { DatabaseDriverFactory(get()) }
}

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(CryptoDatabase.Schema, context, "crypto.db")
    }
}

actual fun roundOffDecimal(value: Double): Double {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    val value = if (value < 0) value * -1 else value
    return df.format(value).toDouble()
}