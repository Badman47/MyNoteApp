package com.example.mynoteapp.screeen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynoteapp.components.NoteButton
import com.example.mynoteapp.components.NoteInputText
import com.example.mynoteapp.data.NoteDataSource
import com.example.mynoteapp.model.Note
import com.example.pokedex.R
import java.time.format.DateTimeFormatter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 5.dp,
            ) {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color(0XFFF0DE36)),
                    title = {
                        Text(
                            text = stringResource(id = R.string.app_name),
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.SemiBold,
                        )
                    },
                    actions = {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "App Icon",
                        )
                    },
                )
            }
        },
    ) {
        Column(
            modifier = Modifier.padding(top = 64.dp).background(Color(0xFFF6FFA6))
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NoteInputText(
                modifier = Modifier
                    .padding(
                        top = 9.dp,
                        bottom = 0.dp,
                    ),
                text = title,
                label = "Title",
                onTextChange = {
                    // When i write something in the title section there is nothing but blank
                    // but if i add this if statement the text shows
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }
                    ) {
                        title = it
                    }
                },
            )
            NoteInputText(
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        bottom = 8.dp,
                    ),
                text = description,
                label = "Add a Note",
                onTextChange = {
                    // When i write something in the title section there is nothing but blank
                    // but if i add this if statement the text shows
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }
                    ) {
                        description = it //I am returning something
                    }
                },
            )
            NoteButton(
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        // We are checking here if the title and description is not empty then we save it in the list
                        // add/save note in the list
                        // When we are adding note we are making a toast message that says note added
                        Toast.makeText(
                            context,
                            "Note Added",
                            Toast.LENGTH_SHORT,
                        ).show()
                        onAddNote(
                            Note(
                                title = title,
                                description = description,
                            ),
                        )
                    }
                },
            )
            Divider(modifier = Modifier.padding(10.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(top = 0.dp).background(Color(0xFFF6FFA6)),
            ) {
                items(notes) { note ->
                    NoteRow(
                        note = note,
                        onNoteClicked = {
                            onRemoveNote(note)
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit,

) {
    Surface(
        modifier = Modifier.fillMaxSize()
            .padding(4.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 33.dp,
                    bottomStart = 33.dp,
                ),
            ).fillMaxWidth(),
        color = Color(0XFFEEF2F5),
        shadowElevation = 6.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .clickable {
                    onNoteClicked(note)
                }
                .padding(
                    horizontal = 16.dp,
                    vertical = 6.dp,
                ),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
            )

            Text(
                text = note.description,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
            )

            Text(
                text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NoteScreen(
        notes = NoteDataSource().loadNotes(),
        onAddNote = {},
        onRemoveNote = {},
    )
}
