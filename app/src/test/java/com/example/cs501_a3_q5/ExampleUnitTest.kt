package com.example.cs501_a3_q5

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

class UnitTest {

    @Test
    fun testCelsiusToFahrenheit() {
        // Arrange
        val celsius = 0

        // Act
        val result = celsiusToFahrenheit(celsius)

        // Assert
        assertEquals(32, result)
    }

    private fun celsiusToFahrenheit(celsius: Int): Int{
        return (celsius * 9 / 5) + 32
    }

    @Test
    fun testFahrenheitToCelsius() {
        // Arrange
        val fahrenheit = 32

        // Act
        val result = fahrenheitToCelsius(fahrenheit)

        // Assert
        assertEquals(0, result)
    }

    private fun fahrenheitToCelsius(fahrenheit: Int): Int{
        return (fahrenheit - 32) * 5 / 9
    }
}
