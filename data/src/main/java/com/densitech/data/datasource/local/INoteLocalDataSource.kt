package com.densitech.data.datasource.local

import com.densitech.data.model.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface INoteLocalDataSource {
    fun getAllNotes(): Flow<List<NoteEntity>>

    fun getNoteById(noteId: String): Flow<NoteEntity?>

    suspend fun insertNote(note: NoteEntity)

    suspend fun updateNote(noteId: String, title: String, content: String, timestamp: Long)

    suspend fun deleteNoteById(noteId: String)
}