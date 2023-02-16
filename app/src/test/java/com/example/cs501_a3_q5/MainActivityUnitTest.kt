package com.example.cs501_a3_q5

import org.junit.Assert.*
import org.junit.Test

class MainActivityUnitTest {

    @Test
    fun testCelsiusToFahrenheit() {
        assertEquals(32, celsiusToFahrenheit(0))
        assertEquals(68, celsiusToFahrenheit(20))
        assertEquals(212, celsiusToFahrenheit(100))
        assertEquals(-40, celsiusToFahrenheit(-40))
    }

    private fun celsiusToFahrenheit(celsius: Int): Int{
        return (celsius * 9 / 5) + 32
    }

    @Test
    fun testFahrenheitToCelsius() {
        assertEquals(0, fahrenheitToCelsius(32))
        assertEquals(20, fahrenheitToCelsius(68))
        assertEquals(100, fahrenheitToCelsius(212))
        assertEquals(-40, fahrenheitToCelsius(-40))
    }

    private fun fahrenheitToCelsius(fahrenheit: Int): Int{
        return (fahrenheit - 32) * 5 / 9
    }
}