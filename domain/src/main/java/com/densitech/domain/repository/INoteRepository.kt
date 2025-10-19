package com.densitech.domain.repository

import com.densitech.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface INoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    fun getNoteById(noteId: String): Flow<Note?>

    suspend fun insertNote(note: Note)

    suspend fun updateNote(noteId: String, title: String, content: String, timestamp: Long)

    suspend fun deleteNoteById(noteId: String)
}