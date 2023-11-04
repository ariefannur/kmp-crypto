package com.github.ariefannur.kmm.crypto.presentation

import androidx.compose.ui.window.ComposeUIViewController
import com.github.ariefannur.kmm.crypto.model.Coin
import platform.UIKit.UIViewController

fun DetailCoinViewController(coin: Coin): UIViewController {
    return ComposeUIViewController {
        DetailCoinScreen(coin)
    }
}