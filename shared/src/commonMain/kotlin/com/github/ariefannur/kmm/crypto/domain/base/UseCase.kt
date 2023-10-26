package com.github.ariefannur.kmm.crypto.domain.base

import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Flow<Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        callback: (DataState<Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Default) {
            try {
                callback.invoke(DataState.Loading)
                val deferred = async {  run(params) }
                deferred.await().collect {
                    callback.invoke(DataState.Success(it))
                }
            } catch (e: Exception) {
                callback.invoke(DataState.Failure(404, e.message ?: ""))
            }
        }
    }

    class None

    @NativeCoroutineScope
    val coroutineScope: CoroutineScope = MainScope()

    fun runNative(params: Params, callback: (DataStateNative<Type>) -> Unit = {}) {
        coroutineScope.launch(Dispatchers.Default) {
            try {
                callback.invoke(DataStateNative(NATIVE_LOADING))
                val deferred = async {  run(params) }
                deferred.await().collect {
                    callback.invoke(DataStateNative(NATIVE_SUCCESS, it))
                }
            } catch (e: Exception) {
                callback.invoke(DataStateNative( state = NATIVE_ERROR, error = ErrorNative(404, e.message ?: "")))
            }
        }
    }
}