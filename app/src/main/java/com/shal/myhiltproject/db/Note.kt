package com.shal.myhiltproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "note") val note: String
)