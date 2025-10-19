package com.densitech.domain.usecase.note

import com.densitech.domain.model.Note
import com.densitech.domain.repository.INoteRepository
import com.densitech.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class InsertNoteUseCase constructor(
    private val noteRepository: INoteRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Note, Unit>(
    dispatcher = dispatcher
) {
    override suspend fun execute(params: Note) {
        noteRepository.insertNote(params)
    }
}