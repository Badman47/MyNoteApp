package com.example.mynoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.mynoteapp.screeen.NoteScreen
import com.example.mynoteapp.screeen.NoteViewModel
import com.example.mynoteapp.ui.theme.MyNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // this is a dependency container
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNoteAppTheme {
                // A surface container using the 'background' color from the theme

                // NEXT STEP IS TO MANAGE STATE AND DATA IN COMPOSE
                // Host the state
                // Stackblitz - > to test the project environment
                // We want to create a remember state here because if we click on the Save Button it saves the note in the list
                val noteViewModel: NoteViewModel by viewModels()
                NotesApp(noteViewModel)
            }
        }
    }
}

// We are passing the note parameter first and calling our notesViewModel
@Composable
fun NotesApp(noteViewModel: NoteViewModel = NoteViewModel()) {
    // Then we are making a function to get all the notes from our noteslist
    val notesList = noteViewModel.getAllNote()
    // Then we are calling our notescreen in which we are adding and removes notes
    NoteScreen(
        notes = notesList,
        onRemoveNote = { noteViewModel.removeNote(it) },
        onAddNote = { noteViewModel.addNote(it) },
    )
}
