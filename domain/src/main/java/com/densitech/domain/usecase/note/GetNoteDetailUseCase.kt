package com.densitech.domain.usecase.note

import com.densitech.domain.model.Note
import com.densitech.domain.repository.INoteRepository
import com.densitech.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow

class GetNoteDetailUseCase constructor(
    private val noteRepository: INoteRepository
) : FlowUseCase<String, Note?>() {
    override fun execute(params: String): Flow<Note?> {
       return noteRepository.getNoteById(params)
    }
}