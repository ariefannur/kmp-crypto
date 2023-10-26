package com.github.ariefannur.kmm.crypto.android.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ariefannur.kmm.crypto.android.R

@Composable
fun PortfolioContent(modifier: Modifier = Modifier
    .height(150.dp)
    .padding(16.dp)) {
    Column (modifier = modifier){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), horizontalArrangement = Arrangement.Center){
            Text(text = "\$", modifier = Modifier.align(alignment = Alignment.CenterVertically), style = MaterialTheme.typography.bodySmall)
            Text(text = "1420.00",
                style = MaterialTheme.typography.displayLarge,
            )
        }
        Text(text = "Portfolio Value", style = MaterialTheme.typography.bodySmall, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Text(text = stringResource(R.string.some_value), style = MaterialTheme.typography.labelSmall, modifier = Modifier.align(alignment = Alignment.CenterHorizontally), color = MaterialTheme.colorScheme.error)
    }
}

@Preview
@Composable
fun PortfolioContentPreview() {
    Column (modifier = Modifier.padding(16.dp)){
        Row {
            Text(text = "$", modifier = Modifier.align(alignment = Alignment.CenterVertically))
            Text(text = "1420.00",
                style = MaterialTheme.typography.displayLarge
            )
        }
        Text(text = "Portfolio Value", style = MaterialTheme.typography.bodySmall, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Text(text = "+250.00(10%)", style = MaterialTheme.typography.labelSmall, modifier = Modifier.align(alignment = Alignment.CenterHorizontally), color = MaterialTheme.colorScheme.error)
    }
}