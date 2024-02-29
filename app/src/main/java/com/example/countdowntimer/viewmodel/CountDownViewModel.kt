package com.example.countdowntimer.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countdowntimer.model.CountDownData

class CountDownViewModel : ViewModel() {

    private val _countdown = MutableLiveData<CountDownData>()
    val countdown: LiveData<CountDownData>
        get() = _countdown

    private lateinit var timer: CountDownTimer

    fun startTimer(totalSeconds: Long) {
        timer = object : CountDownTimer(totalSeconds * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timeRemaining = calculateTimeRemaining(millisUntilFinished)
                _countdown.postValue(timeRemaining)
            }

            override fun onFinish() {
                _countdown.value = CountDownData(
                    0.toString().prependZeroIfSingleDigit(),
                    0.toString().prependZeroIfSingleDigit(),
                    0.toString().prependZeroIfSingleDigit(),
                    0.toString().prependZeroIfSingleDigit())
            }
        }
        timer.start()
    }

    private fun calculateTimeRemaining(millisUntilFinished: Long): CountDownData {
        val totalSeconds = millisUntilFinished / 1000

        val days = totalSeconds / (24 * 3600)
        val hours = (totalSeconds % (24 * 3600)) / 3600
        val minutes = ((totalSeconds % 3600) / 60)
        val seconds = (totalSeconds % 60)
        return CountDownData(
            days.toString().prependZeroIfSingleDigit(),
            hours.toString().prependZeroIfSingleDigit(),
            minutes.toString().prependZeroIfSingleDigit(),
            seconds.toString().prependZeroIfSingleDigit())
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    private fun String.prependZeroIfSingleDigit(): String {
        return if (length == 1) {
            "0$this"
        } else {
            this
        }
    }
}
