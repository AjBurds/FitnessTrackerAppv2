package com.example.fitnesstrackerapp2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryItemDao {

    @Insert
    suspend fun insert(historyItem: HistoryItemEntity)

    @Query("SELECT * FROM history_items")
    fun getAllHistoryItems(): LiveData<List<HistoryItemEntity>>
}
