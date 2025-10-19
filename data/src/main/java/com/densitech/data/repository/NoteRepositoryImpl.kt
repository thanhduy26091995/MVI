package com.densitech.data.repository

import com.densitech.data.datasource.local.INoteLocalDataSource
import com.densitech.data.mapper.NoteMapper.toDomainModel
import com.densitech.data.mapper.NoteMapper.toEntity
import com.densitech.domain.model.Note
import com.densitech.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val localDataSource: INoteLocalDataSource
) : INoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return localDataSource.getAllNotes().map { noteEntities ->
            noteEntities.map { entity ->
                entity.toDomainModel()
            }
        }
    }

    override fun getNoteById(noteId: String): Flow<Note?> {
        return localDataSource.getNoteById(noteId).map {
            it?.toDomainModel()
        }
    }

    override suspend fun insertNote(note: Note) {
        localDataSource.insertNote(note.toEntity())
    }

    override suspend fun updateNote(
        noteId: String,
        title: String,
        content: String,
        timestamp: Long
    ) {
        localDataSource.updateNote(noteId, title, content, timestamp)
    }

    override suspend fun deleteNoteById(noteId: String) {
        localDataSource.deleteNoteById(noteId)
    }
}