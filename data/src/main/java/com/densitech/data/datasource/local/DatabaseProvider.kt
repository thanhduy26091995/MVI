package com.densitech.data.datasource.local

object DatabaseProvider {
    @Volatile
    private var INSTANCE: NoteDatabase? = null

    fun getDatabase(context: android.content.Context): NoteDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = androidx.room.Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_database"
            ).addMigrations().build()
            INSTANCE = instance
            instance
        }
    }
}