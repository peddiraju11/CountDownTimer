package com.example.countdowntimer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countdowntimer.databinding.ActivityCounterBinding
import com.example.countdowntimer.viewmodel.CountDownViewModel

class CountDownActivity : AppCompatActivity() {

    private lateinit var countDownViewModel: CountDownViewModel
    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}