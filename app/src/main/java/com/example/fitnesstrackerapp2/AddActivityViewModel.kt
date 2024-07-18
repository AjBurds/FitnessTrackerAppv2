package com.example.fitnesstrackerapp2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddActivityViewModel : ViewModel() {
    val activityType = MutableLiveData<String>()
    val duration = MutableLiveData<String>()
    val caloriesBurned = MutableLiveData<String>()

    private val _navigateToMain = MutableLiveData<Boolean>()
    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    fun saveActivity() {
        // Save activity logic here
        _navigateToMain.value = true
    }

    fun cancel() {
        _navigateToMain.value = true
    }

    fun doneNavigating() {
        _navigateToMain.value = false
    }
}


