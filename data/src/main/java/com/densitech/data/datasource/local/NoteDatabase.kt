package com.densitech.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.densitech.data.model.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}