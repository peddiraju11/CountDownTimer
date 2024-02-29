package com.example.countdowntimer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countdowntimer.databinding.ActivityCounterBinding
import com.example.countdowntimer.model.CountDownData
import com.example.countdowntimer.utils.Constants
import com.example.countdowntimer.viewmodel.CountDownViewModel

class CountDownActivity : AppCompatActivity() {

    private lateinit var countDownViewModel: CountDownViewModel
    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()

        countDownViewModel = ViewModelProvider(this).get(CountDownViewModel::class.java)

        countDownViewModel.countdown.observe(this, Observer {
            updateCountdownUI(it)
        })

        countDownViewModel.startTimer(Constants.TIMER_VALUE) // 60 Sec
    }

    private fun updateCountdownUI(countDownData: CountDownData) {
        binding.apply {

            item1.counterData.text = (countDownData.days).toString()
            item2.counterData.text = (countDownData.hours).toString()
            item3.counterData.text = (countDownData.minutes).toString()
            item4.counterData.text = (countDownData.seconds).toString()




        }
    }

    private fun setData() {
        binding.apply {
            item1.counterName.text = Constants.DAYS
            item2.counterName.text = Constants.HOURS
            item3.counterName.text = Constants.MINUTES
            item4.counterName.text = Constants.SECONDS
        }
    }
}