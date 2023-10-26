package com.github.ariefannur.kmm.crypto.android.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonAction() {
    Row (modifier = Modifier.fillMaxWidth().height(150.dp).padding(16.dp), Arrangement.SpaceAround){
        Column (verticalArrangement = Arrangement.Center){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "")
            }
            Text("Share")
        }
        Column (verticalArrangement = Arrangement.Center){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "")
            }
            Text("Exchange")
        }
        Column (verticalArrangement = Arrangement.Center){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "")
            }
            Text("Receive")
        }
    }
}