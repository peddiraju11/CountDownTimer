package com.example.countdowntimer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countdowntimer.model.CountDownData

class CountDownViewModel : ViewModel() {

    private val _countdown = MutableLiveData<CountDownData>()
    val countdown: LiveData<CountDownData>
        get() = _countdown

}