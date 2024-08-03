package com.example.fitnesstrackerapp2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.fitnesstrackerapp2.HistoryViewModel
import com.example.fitnesstrackerapp2.HistoryItem
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HistoryViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var historyViewModel: HistoryViewModel

    @Mock
    private lateinit var historyItemsObserver: Observer<List<HistoryItem>>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        historyViewModel = HistoryViewModel()

        historyViewModel.historyItems.observeForever(historyItemsObserver)
    }

    @Test
    fun testInitialHistoryItems() {
        val expectedHistory = listOf(
            HistoryItem("Running", 5000, 300, 3.5f),
            HistoryItem("Walking", 8000, 200, 5.0f)
        )

        assertEquals(expectedHistory, historyViewModel.historyItems.value)
    }
}
