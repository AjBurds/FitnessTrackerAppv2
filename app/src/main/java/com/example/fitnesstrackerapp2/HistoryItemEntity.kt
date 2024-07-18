package com.example.fitnesstrackerapp2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_items")
data class HistoryItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val activityType: String,
    val steps: Int,
    val calories: Int,
    val distance: Float
)
