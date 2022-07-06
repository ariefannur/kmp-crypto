package com.github.ariefannur.kmm.crypto.common

import io.ktor.client.engine.darwin.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single { Darwin.create() }
}