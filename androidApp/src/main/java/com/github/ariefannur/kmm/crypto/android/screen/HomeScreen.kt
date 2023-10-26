package com.github.ariefannur.kmm.crypto.android.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.ariefannur.kmm.crypto.android.component.LoadingHome
import com.github.ariefannur.kmm.crypto.android.component.PortfolioContent
import com.github.ariefannur.kmm.crypto.android.component.TopBar
import com.github.ariefannur.kmm.crypto.android.component.WalletList
import com.github.ariefannur.kmm.crypto.android.theme.AppTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(){

    var isDarkMode by remember { mutableStateOf(false) }
    val viewModel: HomeScreenViewModel = getViewModel<HomeScreenViewModel>()

    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()


    AppTheme {
        Scaffold (
            topBar = {
                TopBar(isDarkMode, onChangeMode = {
                    isDarkMode = it
                })
            }
        ) { innerPadding ->

            Column (modifier = Modifier.padding(innerPadding)) {
                when(homeUiState) {
                    is HomeScreenViewModel.HomeScreenUiState.Loading -> LoadingHome()
                    is HomeScreenViewModel.HomeScreenUiState.Success -> {
                        WalletList((homeUiState as HomeScreenViewModel.HomeScreenUiState.Success).data)
                    }
                    is HomeScreenViewModel.HomeScreenUiState.Error -> {

                    }
                }
            }

        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun DefaultPreview() {
    AppTheme {
        Scaffold(
            topBar = {
                TopBar()
            }

        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
            ) {
                PortfolioContent()
                Text(text = "Wallet", modifier = Modifier.padding(16.dp) , style = MaterialTheme.typography.titleLarge)
                WalletList()
            }
        }
    }
}