package com.github.ariefannur.kmm.crypto.domain.base

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
                println("Error ${e.message}")
                callback.invoke(DataState.Failure(404, e.message ?: ""))
            }
        }
    }

    class None
}