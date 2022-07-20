package com.github.ariefannur.kmm.crypto.inject

import com.github.ariefannur.kmm.crypto.domain.GetListingLatest
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class InjectGetListingLatest: KoinComponent {
    private val getListing : GetListingLatest by inject()
    fun listing(): GetListingLatest = getListing
}