package com.shal.myhiltproject.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}