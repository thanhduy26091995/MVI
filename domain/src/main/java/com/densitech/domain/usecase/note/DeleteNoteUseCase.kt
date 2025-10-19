package com.densitech.domain.usecase.note

import com.densitech.domain.repository.INoteRepository
import com.densitech.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class DeleteNoteUseCase(
    private val noteRepository: INoteRepository,
    dispatcher: CoroutineDispatcher
) :
    BaseUseCase<String, Unit>(dispatcher = dispatcher) {
    override suspend fun execute(params: String) {
        noteRepository.deleteNoteById(params)
    }
}