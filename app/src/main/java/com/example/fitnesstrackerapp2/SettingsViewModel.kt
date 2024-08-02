package com.example.fitnesstrackerapp2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private val _dailyStepGoal = MutableLiveData<String>().apply { value = "5000" }
    val dailyStepGoal: LiveData<String> = _dailyStepGoal

    private val _calorieGoal = MutableLiveData<String>().apply { value = "2000" }
    val calorieGoal: LiveData<String> = _calorieGoal

    private val _notificationsEnabled = MutableLiveData<Boolean>().apply { value = true }
    val notificationsEnabled: LiveData<Boolean> = _notificationsEnabled

    fun saveSettings(stepGoal: String, calorieGoal: String, notificationsEnabled: Boolean) {
        _dailyStepGoal.value = stepGoal
        _calorieGoal.value = calorieGoal
        _notificationsEnabled.value = notificationsEnabled
    }
}
