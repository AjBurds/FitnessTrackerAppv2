package com.example.fitnesstrackerapp2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {
    private val _historyItems = MutableLiveData<List<HistoryItem>>()
    val historyItems: LiveData<List<HistoryItem>>
        get() = _historyItems

    init {
        // Sample data for demonstration
        _historyItems.value = listOf(
            HistoryItem("Running", 5000, 300, 3.5f),
            HistoryItem("Walking", 8000, 200, 5.0f)
        )
    }
}