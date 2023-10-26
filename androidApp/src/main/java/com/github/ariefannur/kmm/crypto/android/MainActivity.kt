package com.github.ariefannur.kmm.crypto.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import com.github.ariefannur.kmm.crypto.android.screen.HomeScreen
import com.github.ariefannur.kmm.crypto.domain.GetListingLatest
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}


