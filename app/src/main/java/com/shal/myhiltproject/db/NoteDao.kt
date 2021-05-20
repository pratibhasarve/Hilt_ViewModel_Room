package com.shal.myhiltproject.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table")
    fun getNotes(): Flow<List<Note>>

    @Insert
    fun insertNote(note: Note)

    @Query("DELETE FROM notes_table")
    fun deleteNote()

}