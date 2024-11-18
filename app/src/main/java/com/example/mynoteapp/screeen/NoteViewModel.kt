package com.example.mynoteapp.screeen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mynoteapp.data.NoteDataSource
import com.example.mynoteapp.model.Note

// : ViewModel it means it will inherit from the view-model library
class NoteViewModel : ViewModel() {
    // <Note> is the type of elements in the list

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    // We are passing the note object (1:2)
    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNote(): List<Note> {
        return noteList
    }
}





