package com.densitech.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.densitech.data.model.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun getNoteById(noteId: String): Flow<NoteEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    suspend fun updateNote(noteId: String, title: String, content: String, timestamp: Long) {
        val note = getNoteByIdSync(noteId)
        if (note != null) {
            val updatedNote = note.copy(title = title, content = content, timestamp = timestamp)
            insertNote(updatedNote)
        }
    }

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteByIdSync(noteId: String): NoteEntity?

    @Query("UPDATE notes SET isDeleted = 1 WHERE id = :noteId")
    suspend fun deleteNoteById(noteId: String)
}