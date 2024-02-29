package com.example.countdowntimer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countdowntimer.databinding.ActivityCounterBinding
import com.example.countdowntimer.model.CountDownData
import com.example.countdowntimer.viewmodel.CountDownViewModel

class CountDownActivity : AppCompatActivity() {

    private lateinit var countDownViewModel: CountDownViewModel
    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countDownViewModel = ViewModelProvider(this).get(CountDownViewModel::class.java)

        countDownViewModel.countdown.observe(this, Observer {
            updateCountdownUI(it)
        })

        countDownViewModel.startTimer(60) // 60 Sec
    }

    private fun updateCountdownUI(data: CountDownData) {
        binding.apply {
            counterText.text = data.seconds.toString()
        }
    }
}