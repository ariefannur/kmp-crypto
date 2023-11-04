package com.github.ariefannur.kmm.crypto.android.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ariefannur.kmm.crypto.domain.GetListingLatest
import com.github.ariefannur.kmm.crypto.domain.base.DataState
import com.github.ariefannur.kmm.crypto.model.Coin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel(
    private val getListingLatest: GetListingLatest
): ViewModel() {
    private val _state: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(HomeScreenUiState.Loading)
    val homeUiState: StateFlow<HomeScreenUiState> = _state.asStateFlow()

    private var _dataList = mutableListOf<Coin>()
    fun getDetailCoin(symbol: String): Coin? {
        return _dataList.find { it.symbol == symbol }
    }

    init {
        getListing()
    }
    fun getListing() {
        getListingLatest("", scope = viewModelScope) {
            when(it) {
                is DataState.Loading -> _state.value = HomeScreenUiState.Loading
                is DataState.Success -> {
                    _dataList = it.result.toMutableList()
                    _state.value = HomeScreenUiState.Success(it.result)
                }
                is DataState.Failure -> _state.value = HomeScreenUiState.Error(it.message)
            }
        }
    }

    sealed interface HomeScreenUiState {
        data object Loading : HomeScreenUiState
        data class Success(val data: List<Coin>) : HomeScreenUiState
        data class Error(val message: String) : HomeScreenUiState
    }

}