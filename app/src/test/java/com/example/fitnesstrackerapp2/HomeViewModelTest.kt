package com.example.fitnesstrackerapp2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.fitnesstrackerapp2.HomeViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var dailyStepsObserver: Observer<Int>

    @Mock
    private lateinit var caloriesBurnedObserver: Observer<Int>

    @Mock
    private lateinit var distanceCoveredObserver: Observer<Float>

    @Mock
    private lateinit var dailyGoalObserver: Observer<String>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        homeViewModel = HomeViewModel()

        homeViewModel.dailySteps.observeForever(dailyStepsObserver)
        homeViewModel.caloriesBurned.observeForever(caloriesBurnedObserver)
        homeViewModel.distanceCovered.observeForever(distanceCoveredObserver)
        homeViewModel.dailyGoal.observeForever(dailyGoalObserver)
    }

    @Test
    fun testInitialValues() {
        assertEquals(0, homeViewModel.dailySteps.value)
        assertEquals(0, homeViewModel.caloriesBurned.value)
        assertEquals(0f, homeViewModel.distanceCovered.value)
        assertEquals("5,000 steps", homeViewModel.dailyGoal.value)
    }

    @Test
    fun testUpdateDailyProgress() {
        homeViewModel.updateDailyProgress(1000, 50, 1.2f)

        assertEquals(1000, homeViewModel.dailySteps.value)
        assertEquals(50, homeViewModel.caloriesBurned.value)
        assertEquals(1.2f, homeViewModel.distanceCovered.value)
    }
}
