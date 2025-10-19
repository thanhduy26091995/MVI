package com.densitech.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

abstract class FlowUseCase<in P, out R>(
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(params: P): Flow<Result<R>> {
        return execute(params).mapToResult()
    }

    protected abstract fun execute(params: P): Flow<R>

    private fun Flow<R>.mapToResult(): Flow<Result<R>> {
        return this.map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }
    }
}