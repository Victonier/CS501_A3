package com.example.cs501_a3_q5

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.cs501_a3_q5", appContext.packageName)
    }
}


@RunWith(AndroidJUnit4::class)
class InstrumentedTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testCelsiusToFahrenheit() {
        assertEquals(32, celsiusToFahrenheit(0))
        assertEquals(68, celsiusToFahrenheit(20))
        assertEquals(212, celsiusToFahrenheit(100))
        assertEquals(-40, celsiusToFahrenheit(-40))
    }

    private fun celsiusToFahrenheit(celsius: Int): Int {
        return (celsius * 9 / 5) + 32
    }

    @Test
    fun testFahrenheitToCelsius() {
        assertEquals(0, fahrenheitToCelsius(32))
        assertEquals(20, fahrenheitToCelsius(68))
        assertEquals(100, fahrenheitToCelsius(212))
        assertEquals(-40, fahrenheitToCelsius(-40))
    }

    private fun fahrenheitToCelsius(fahrenheit: Int): Int {
        return (fahrenheit - 32) * 5 / 9
    }
}
