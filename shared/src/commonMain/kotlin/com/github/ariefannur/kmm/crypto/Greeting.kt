package com.github.ariefannur.kmm.crypto

import com.github.ariefannur.kmm.crypto.common.Platform

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}