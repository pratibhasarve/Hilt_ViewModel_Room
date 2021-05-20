package com.shal.myhiltproject.db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    var allNotes: Flow<List<Note>> = noteDao.getNotes()

    @WorkerThread
    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    @WorkerThread
    suspend fun deleteNote() {
        noteDao.deleteNote()
    }
}