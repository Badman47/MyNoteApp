package com.example.mynoteapp.data

import com.example.mynoteapp.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Match Day",
                description = "Go to the match field",
            ),
            Note(
                title = "Gym Day",
                description = "Go to the Gym",
            ),
            Note(
                title = "Laundry Day",
                description = "Go to the washing area",
            ),
            Note(
                title = "Cooking Time",
                description = "Go to the kitchen",
            ),
            Note(
                title = "Cleaning RoomDay",
                description = "Clean the room",
            ),
            Note(
                title = "Match Day",
                description = "Go to the Sports Arena",
            ),
            Note(
                title = "Netflix Day",
                description = "Continue watching vikings",
            ),
            Note(
                title = "Call Day",
                description = "Go to the ROOM",
            ),
            Note(
                title = "Drinking Day",
                description = "Go to the BAR",
            ),
            Note(
                title = "Cycling Day",
                description = "Go to the Track",
            ),
            Note(
                title = "Reading Day",
                description = "Complete the research paper",
            ),

        )
    }
}
