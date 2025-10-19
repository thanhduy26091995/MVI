package com.densitech.domain.usecase.note

import com.densitech.domain.model.Note
import com.densitech.domain.repository.INoteRepository
import com.densitech.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(
    private val noteRepository: INoteRepository,
    dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<Note>>(dispatcher = dispatcher) {

    override fun execute(params: Unit): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }
}