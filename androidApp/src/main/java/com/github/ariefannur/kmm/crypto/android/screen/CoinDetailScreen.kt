package com.github.ariefannur.kmm.crypto.android.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.ariefannur.kmm.crypto.android.component.BottomDetailCoin
import com.github.ariefannur.kmm.crypto.android.component.ButtonAction
import com.github.ariefannur.kmm.crypto.android.component.ChartCoin

const val ARROW_DOWN = "&#x2198;"
const val ARROW_UP = "\\2197"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinDetailScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Detail") },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) {
        Column(Modifier.padding(it)) {
            Row (Modifier.padding(16.dp)){
                AsyncImage(model = "http:://image", modifier = Modifier.size(40.dp), contentDescription = "icon")
                Column (modifier = Modifier.padding(start = 12.dp)){
                    Text("\$12.323", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.inverseSurface)
                    Text(text = "↗ 0.60%"
                    , style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.inverseSurface)
                }
            }
            ChartCoin()
            ButtonAction()
            BottomDetailCoin()
        }
    }
}

@Preview
@Composable
fun CoinDetailPreview() {
    CoinDetailScreen()
}