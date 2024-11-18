package com.example.mynoteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

// Setting up our table name through entity annotation
@Entity("notes_tbl")
data class Note(

    // Setting up the primary key for our table which will be a unique id
    @PrimaryKey
    val id: UUID = UUID.randomUUID(), // it creates random unique id so we don't have to handle them manually

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String,

    @ColumnInfo(name = "note_entry_date")
    val entryDate: Date = Date.from(Instant.now()), // Timestamp is created according to the local time
)
