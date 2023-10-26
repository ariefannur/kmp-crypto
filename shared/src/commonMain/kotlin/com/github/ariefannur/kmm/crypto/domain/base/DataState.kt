package com.github.ariefannur.kmm.crypto.domain.base

sealed class DataState<out T: Any>{
    object Loading: DataState<Nothing>()
    data class Success<T: Any>(val result: T) : DataState<T>()
    data class Failure(val errorCode: Int, val message: String) : DataState<Nothing>()
}

data class DataStateNative<out T: Any>(val state: Int, val result: T? = null, val error: ErrorNative? = null)
data class ErrorNative(val code: Int, val message: String)

const val NATIVE_LOADING = 1
const val NATIVE_SUCCESS = 2
const val NATIVE_ERROR = 3