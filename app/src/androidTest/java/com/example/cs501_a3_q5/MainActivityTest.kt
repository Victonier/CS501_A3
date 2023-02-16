package com.example.cs501_a3_q5

import android.widget.SeekBar
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testCelsiusSeekBarMatchesTextView() {
        scenario.onActivity { activity ->
            val celsiusSeekbar = activity.findViewById<SeekBar>(R.id.seekBar_celsius)
            val celsiusTextBox = activity.findViewById<TextView>(R.id.celsiusValueBox)

            celsiusSeekbar.progress = 20
            assertEquals("20", celsiusTextBox.text.toString())
        }
    }

    @Test
    fun testFahrenheitSeekBarMatchesTextView() {
        scenario.onActivity { activity ->
            val fahrenheitSeekbar = activity.findViewById<SeekBar>(R.id.seekBar_fahrenheit)
            val fahrenheitTextBox = activity.findViewById<TextView>(R.id.fahrenheitValueBox)

            fahrenheitSeekbar.progress = 40
            assertEquals("40", fahrenheitTextBox.text.toString())
        }
    }

    @Test
    fun testFahrenheitBelow32() {
        scenario.onActivity { activity ->
            val fahrenheitSeekbar = activity.findViewById<SeekBar>(R.id.seekBar_fahrenheit)
            val fahrenheitTextBox = activity.findViewById<TextView>(R.id.fahrenheitValueBox)

            fahrenheitSeekbar.progress = 30
            assertNotEquals("30", fahrenheitTextBox.text.toString())
            assertEquals("32", fahrenheitTextBox.text.toString())
        }
    }

    @Test
    fun testCelsiusBarChangesFahrenheitBar() {
        scenario.onActivity { activity ->
            val celsiusSeekbar = activity.findViewById<SeekBar>(R.id.seekBar_celsius)
            val fahrenheitSeekbar = activity.findViewById<SeekBar>(R.id.seekBar_fahrenheit)

            celsiusSeekbar.progress = 20
            assertEquals(fahrenheitSeekbar.progress, celsiusToFahrenheit(20))
        }
    }

    private fun celsiusToFahrenheit(celsius: Int): Int {
        return (celsius * 9 / 5) + 32
    }

    private fun fahrenheitToCelsius(fahrenheit: Int): Int {
        return (fahrenheit - 32) * 5 / 9
    }

}