package com.example.countdowntimer.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countdowntimer.R
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

        clickSocial()
    }

    private fun updateCountdownUI(countDownData: CountDownData) {
        binding.apply {

            addAnim(item1.counterData,countDownData.days, item1.counterCard )
            addAnim(item2.counterData,countDownData.hours, item2.counterCard )
            addAnim(item3.counterData,countDownData.minutes, item3.counterCard )
            addAnim(item4.counterData,countDownData.seconds, item4.counterCard )

            item1.counterData.text = (countDownData.days).toString()
            item2.counterData.text = (countDownData.hours).toString()
            item3.counterData.text = (countDownData.minutes).toString()
            item4.counterData.text = (countDownData.seconds).toString()

        }
    }

    private fun addAnim(counterData: TextView, timeValue: String, counterCard: CardView) {
        binding.apply {
            if (counterData.text != (timeValue))
                counterCard.startAnimation(
                    AnimationUtils.loadAnimation(
                        applicationContext,
                        R.anim.up_animator
                    )
                )
            else
                counterCard.clearAnimation()
        }
    }

    private fun setData() {
        binding.apply {
            item1.counterName.text = Constants.DAYS
            item2.counterName.text = Constants.HOURS
            item3.counterName.text = Constants.MINUTES
            item4.counterName.text = Constants.SECONDS

            imageItem1.imageView.setImageDrawable(
                ContextCompat.getDrawable(baseContext, R.mipmap.facebook)
            )

            imageItem2.imageView.setImageDrawable(
                ContextCompat.getDrawable(baseContext, R.mipmap.instagram)
            )

            imageItem3.imageView.setImageDrawable(
                ContextCompat.getDrawable(baseContext, R.mipmap.linkedin)
            )

        }
    }

    private fun clickSocial() {
        binding.apply {

            imageItem1.imageView.setOnClickListener {
                openFacebookProfile()
            }

            imageItem2.imageView.setOnClickListener {
                openInstagramProfile()
            }

            imageItem3.imageView.setOnClickListener {
                openLinkedInProfile()
            }
        }
    }

    private fun openFacebookProfile() {
        try {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/${Constants.FACEBOOK_PROFILE}"))
            startActivity(intent)
        } catch (e: Exception) {
            // If the Facebook app is not installed, open the profile in a web browser
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/$Constants.FACEBOOK_PROFILE")
            )
            startActivity(intent)
        }
    }

    private fun openInstagramProfile() {
        try {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.instagram.com/_u/${Constants.INSTAGRAM_PROFILE}")
            )
            intent.setPackage("com.instagram.android")
            startActivity(intent)
        } catch (e: Exception) {
            // If Instagram app is not installed, open the profile in a web browser
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.instagram.com/${Constants.INSTAGRAM_PROFILE}")
            )
            startActivity(intent)
        }
    }

    private fun openLinkedInProfile() {
        try {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("linkedin://profile/${Constants.LINKEDIN_PROFILE}")
            )
            startActivity(intent)
        } catch (e: Exception) {
            // If LinkedIn app is not installed, open the profile in a web browser
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.linkedin.com/in/${Constants.LINKEDIN_PROFILE}")
            )
            startActivity(intent)
        }
    }
}
