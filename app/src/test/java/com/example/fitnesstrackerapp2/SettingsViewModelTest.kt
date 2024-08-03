package com.example.fitnesstrackerapp2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.fitnesstrackerapp2.SettingsViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SettingsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var settingsViewModel: SettingsViewModel

    @Mock
    private lateinit var dailyStepGoalObserver: Observer<String>

    @Mock
    private lateinit var calorieGoalObserver: Observer<String>

    @Mock
    private lateinit var notificationsEnabledObserver: Observer<Boolean>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        settingsViewModel = SettingsViewModel()

        settingsViewModel.dailyStepGoal.observeForever(dailyStepGoalObserver)
        settingsViewModel.calorieGoal.observeForever(calorieGoalObserver)
        settingsViewModel.notificationsEnabled.observeForever(notificationsEnabledObserver)
    }

    @Test
    fun testInitialValues() {
        assertEquals("5000", settingsViewModel.dailyStepGoal.value)
        assertEquals("2000", settingsViewModel.calorieGoal.value)
        assertEquals(true, settingsViewModel.notificationsEnabled.value)
    }

    @Test
    fun testSaveSettings() {
        settingsViewModel.saveSettings("6000", "1500", false)

        assertEquals("6000", settingsViewModel.dailyStepGoal.value)
        assertEquals("1500", settingsViewModel.calorieGoal.value)
        assertEquals(false, settingsViewModel.notificationsEnabled.value)
    }
}
