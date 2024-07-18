package com.example.fitnesstrackerapp2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _welcomeMessage = MutableLiveData<String>().apply {
        value = "Welcome to Fitness Tracker"
    }
    val welcomeMessage: LiveData<String> = _welcomeMessage

    private val _steps = MutableLiveData<Int>().apply {
        value = 1000
    }
    val steps: LiveData<Int> = _steps

    private val _calories = MutableLiveData<Int>().apply {
        value = 50
    }
    val calories: LiveData<Int> = _calories

    private val _distance = MutableLiveData<Double>().apply {
        value = 0.8
    }
    val distance: LiveData<Double> = _distance

    fun updateSteps(newSteps: Int) {
        _steps.value = newSteps
    }

    fun updateCalories(newCalories: Int) {
        _calories.value = newCalories
    }

    fun updateDistance(newDistance: Double) {
        _distance.value = newDistance
    }
}
