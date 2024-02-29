package com.example.countdowntimer.utils

import org.junit.Assert
import org.junit.Test

class ConstantsTest {

    @Test
    fun testConstantValues() {
        Assert.assertEquals("DAYS", Constants.DAYS)
        Assert.assertEquals("HOURS", Constants.HOURS)
        Assert.assertEquals("MINUTES", Constants.MINUTES)
        Assert.assertEquals("SECONDS", Constants.SECONDS)
        Assert.assertEquals(500490L, Constants.TIMER_VALUE)
        Assert.assertEquals("ginnedumu.peddiraju", Constants.FACEBOOK_PROFILE)
        Assert.assertEquals("raju_real1", Constants.INSTAGRAM_PROFILE)
        Assert.assertEquals("peddiraju-ginnedumu", Constants.LINKEDIN_PROFILE)
    }
}