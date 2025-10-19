package com.densitech.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in P, out R>(
    private val dispatcher: CoroutineDispatcher
) {
    protected abstract suspend fun execute(params: P): R

    suspend operator fun invoke(params: P): Result<R> {
        return try {
            val result = withContext(dispatcher) {
                execute(params)
            }
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}