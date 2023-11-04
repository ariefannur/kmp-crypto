package com.github.ariefannur.kmm.crypto.android.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.github.ariefannur.kmm.crypto.android.utils.roundOffDecimal
import com.github.ariefannur.kmm.crypto.model.Coin

@Composable
fun WalletList(data: List<Coin> = listOf(), onItemClick: (Coin) -> Unit) {
    LazyColumn {
        item {
            PortfolioContent()
        }
        item {
            Text(
                text = "Wallet",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                style = MaterialTheme.typography.titleLarge
            )
        }
        items(data) { it ->
            ItemWalletList(it, onItemClick)
        }
    }
}
@Composable
fun ItemWalletList(coin: Coin, onItemClick: (Coin) -> Unit) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .selectable(selected = true,
        onClick = {
            onItemClick.invoke(coin)
        })
        ,verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(model = coin.imgLogo, modifier = Modifier.size(32.dp), contentDescription = "icon")
        Column (modifier = Modifier.padding(start = 12.dp)){
            Text(coin.name, style = MaterialTheme.typography.bodyMedium)
            Text("${coin.symbol} . \$${coin.price.roundOffDecimal()}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.inverseSurface)
        }
        Spacer(Modifier.weight(1f))
        Column (Modifier.width(60.dp)){
            Text("${coin.move24}", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Right)
            Text("${if (coin.percentage < 0) "-" else ""} %${coin.percentage.roundOffDecimal()}", style = MaterialTheme.typography.labelSmall, textAlign = TextAlign.End,
                    color = if (coin.percentage < 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                )
        }
    }
}
