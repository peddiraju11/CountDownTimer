package com.example.countdowntimer.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.countdowntimer.model.CountDownData
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CountDownViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<CountDownData>

    private lateinit var viewModel: CountDownViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = CountDownViewModel()
        viewModel.countdown.observeForever(observer)
    }

    @Test
    fun `startTimer should update countdown LiveData`() {
        // Given
        val totalSeconds = 60L

        // When
        viewModel.startTimer(totalSeconds)

        // Then
        Mockito.verify(observer).onChanged(Mockito.any())
    }

    @Test
    fun `calculateTimeRemaining should return correct CountDownData`() {
        // Given
        val millisUntilFinished = 60000L

        // When
        val result = viewModel.calculateTimeRemaining(millisUntilFinished)

        // Then
        assert(result.days == "00")
        assert(result.hours == "00")
        assert(result.minutes == "01")
        assert(result.seconds == "00")
    }

}

