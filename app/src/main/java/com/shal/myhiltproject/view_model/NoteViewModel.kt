package com.shal.myhiltproject.view_model

import android.app.Application
import androidx.lifecycle.*
import com.shal.myhiltproject.db.Note
import com.shal.myhiltproject.db.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {

    val allNotes: LiveData<List<Note>> = noteRepository.allNotes.asLiveData()

    fun insertNote(note: Note) =
        viewModelScope.launch(Dispatchers.IO) { noteRepository.insertNote(note) }

    fun deleteNote() =
        viewModelScope.launch(Dispatchers.IO) { noteRepository.deleteNote() }
}