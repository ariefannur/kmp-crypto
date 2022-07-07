package com.github.ariefannur.kmm.crypto.data.di

import com.github.ariefannur.kmm.crypto.common.platformModule
import com.github.ariefannur.kmm.crypto.data.ListingRemoteDataSourceImpl
import com.github.ariefannur.kmm.crypto.data.ListingRepositoryImpl
import com.github.ariefannur.kmm.crypto.domain.GetListingLatest
import com.github.ariefannur.kmm.crypto.domain.abstract.ListingRemoteDataSource
import com.github.ariefannur.kmm.crypto.domain.abstract.ListingRepository
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = true, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule(enableNetworkLogs = enableNetworkLogs), platformModule())
    }

// called by iOS etc
fun initKoin() = initKoin(enableNetworkLogs = true) {}

fun commonModule(enableNetworkLogs: Boolean) = module {
    single { createJson() }
    single { createHttpClient(get(), get(), enableNetworkLogs = enableNetworkLogs) }

    single { CoroutineScope(Dispatchers.Default + SupervisorJob() ) }

    single<ListingRemoteDataSource> { ListingRemoteDataSourceImpl(get()) }
    single<ListingRepository> { ListingRepositoryImpl(get()) }

    single { GetListingLatest(get()) }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(httpClientEngine: HttpClientEngine, json: Json, enableNetworkLogs: Boolean) = HttpClient(httpClientEngine) {
    install(ContentNegotiation) {
        json(json)
    }
    if (enableNetworkLogs) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
    }
}