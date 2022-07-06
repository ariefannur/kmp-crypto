package com.github.ariefannur.kmm.crypto.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.ariefannur.kmm.crypto.Greeting
import android.widget.TextView
import com.github.ariefannur.kmm.crypto.domain.GetListingLatest
import org.koin.android.ext.android.inject

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    private val getListingLatest: GetListingLatest by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        getListingLatest("") {
            Log.d("AF", "result : $it")
        }
    }
}
