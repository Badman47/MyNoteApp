package com.example.mynoteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynoteapp.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDatabase
}
