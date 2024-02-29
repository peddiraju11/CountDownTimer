package com.example.countdowntimer.model

import org.junit.Assert
import org.junit.Test
class CountDownDataTest {

    @Test
    fun testEquality() {
        // Create instances of CountDownData with the same values
        val countDown1 = CountDownData("1", "12", "30", "45")
        val countDown2 = CountDownData("1", "12", "30", "45")

        // Test if the instances are equal
        Assert.assertEquals(countDown1, countDown2)
    }
}
