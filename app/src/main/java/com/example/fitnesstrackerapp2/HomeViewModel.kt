package com.example.fitnesstrackerapp2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _dailySteps = MutableLiveData<Int>().apply { value = 0 }
    val dailySteps: LiveData<Int> = _dailySteps

    private val _caloriesBurned = MutableLiveData<Int>().apply { value = 0 }
    val caloriesBurned: LiveData<Int> = _caloriesBurned

    private val _distanceCovered = MutableLiveData<Float>().apply { value = 0f }
    val distanceCovered: LiveData<Float> = _distanceCovered

    private val _dailyGoal = MutableLiveData<String>().apply { value = "5,000 steps" }
    val dailyGoal: LiveData<String> = _dailyGoal

    // Example function to update data
    fun updateDailyProgress(steps: Int, calories: Int, distance: Float) {
        _dailySteps.value = steps
        _caloriesBurned.value = calories
        _distanceCovered.value = distance
    }
}