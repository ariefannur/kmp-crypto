package com.github.ariefannur.kmm.crypto.android.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomDetailCoin() {
    Column (modifier = Modifier.padding(16.dp)){
        Text("In Wallet", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 16.dp))
        Row {
            Text(text = "0.132323", style = MaterialTheme.typography.titleMedium)
            Text(text = "BTC", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "\$123.002", style = MaterialTheme.typography.bodyMedium)
        }
        Text(text = "\$123.002 -> \$123.002 ", style = MaterialTheme.typography.bodyMedium)
        Row (modifier = Modifier.fillMaxWidth().padding(top =16.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {}, modifier = Modifier.weight(1f).padding(end = 16.dp).height(48.dp), shape = MaterialTheme.shapes.medium) {
                Text(text = "Buy")
            }
            Button(onClick = {}, modifier = Modifier.weight(1f).height(48.dp), shape = MaterialTheme.shapes.medium) {
                Text(text = "Sell")
            }
        }
    }
}