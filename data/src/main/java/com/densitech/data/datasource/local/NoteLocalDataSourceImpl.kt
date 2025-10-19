package com.densitech.data.datasource.local

import com.densitech.data.model.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteLocalDataSourceImpl @Inject constructor( private val dao: NoteDao) : INoteLocalDataSource {
    override fun getAllNotes(): Flow<List<NoteEntity>> {
        return dao.getAllNotes()
    }

    override fun getNoteById(noteId: String): Flow<NoteEntity?> {
        return dao.getNoteById(noteId)
    }

    override suspend fun insertNote(note: NoteEntity) {
        dao.insertNote(note)
    }

    override suspend fun updateNote(
        noteId: String,
        title: String,
        content: String,
        timestamp: Long
    ) {
        dao.updateNote(noteId, title, content, timestamp)
    }

    override suspend fun deleteNoteById(noteId: String) {
        dao.deleteNoteById(noteId)
    }
}