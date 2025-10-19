package com.densitech.domain.usecase.note

import com.densitech.domain.repository.INoteRepository
import com.densitech.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class UpdateNoteUseCase(
    private val noteRepository: INoteRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<UpdateNoteUseCase.Params, Unit>(dispatcher = dispatcher) {

    data class Params(
        val noteId: String,
        val title: String,
        val content: String
    )

    override suspend fun execute(params: Params) {
        with(params) {
            noteRepository.updateNote(noteId, title, content, System.currentTimeMillis())
        }
    }
}