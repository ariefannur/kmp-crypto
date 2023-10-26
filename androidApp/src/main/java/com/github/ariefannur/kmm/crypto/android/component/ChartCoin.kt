package com.github.ariefannur.kmm.crypto.android.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChartCoin() {

    Column {
        Row(
            Modifier
                .height(150.dp)
                .background(Color.Cyan)) {

        }

        val buttonSelected = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        val buttonUnSelected = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {  }, shape = MaterialTheme.shapes.medium, colors = buttonSelected) {
                Text("D")
            }
            FilledTonalButton(onClick = {}, shape = MaterialTheme.shapes.medium, colors = buttonUnSelected) {
                Text("W")
            }
            FilledTonalButton(onClick = {}, shape = MaterialTheme.shapes.medium, colors = buttonUnSelected) {
                Text("M")
            }
            FilledTonalButton(onClick = {}, shape = MaterialTheme.shapes.medium, colors = buttonUnSelected) {
                Text("Y")
            }
        }
    }
}