package com.example.cs501_a3_q5

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var celsiusSeekBar: SeekBar
    private lateinit var fahrenheitSeekBar: SeekBar
    private lateinit var celsiusTextView: TextView
    private lateinit var fahrenheitTextView: TextView
    private lateinit var temperatureCelsiusTextView:TextView
    private lateinit var temperatureFahrenheitTextView:TextView

    private val MIN_CELSIUS = 0
    private val MAX_CELSIUS = 100
    private val MIN_FAHRENHEIT = 0
    private val MAX_FAHRENHEIT = 212

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the views
        celsiusSeekBar = findViewById(R.id.seekBar_celsius)
        fahrenheitSeekBar = findViewById(R.id.seekBar_fahrenheit)
        celsiusTextView = findViewById(R.id.Celsius)
        fahrenheitTextView = findViewById(R.id.Fahrenheit)
        temperatureCelsiusTextView = findViewById(R.id.celsiusValueBox)
        temperatureFahrenheitTextView = findViewById(R.id.fahrenheitValueBox)

        // Initialize the SeekBar components
        celsiusSeekBar.max = MAX_CELSIUS - MIN_CELSIUS
        celsiusSeekBar.progress = 0
        fahrenheitSeekBar.max = MAX_FAHRENHEIT - MIN_FAHRENHEIT
        // initial value: fahrenheit >= 32
        fahrenheitSeekBar.progress = 32

        // Set the listener for the Celsius SeekBar
        celsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val celsius = MIN_CELSIUS + progress
                val fahrenheit = celsiusToFahrenheit(celsius)

                fahrenheitSeekBar.progress = fahrenheit - MIN_FAHRENHEIT
                temperatureCelsiusTextView.text = "$celsius"
                temperatureFahrenheitTextView.text = "$fahrenheit"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Set the listener for the Fahrenheit SeekBar
        fahrenheitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                val fahrenheit = MIN_FAHRENHEIT + progress
                if (fahrenheit < 32) {
                    fahrenheitSeekBar.progress = 32 - MIN_FAHRENHEIT
                    celsiusSeekBar.progress = 0
                    temperatureCelsiusTextView.text = "0"
                    temperatureFahrenheitTextView.text = "32"
                } else {
                    val celsius = fahrenheitToCelsius(fahrenheit)
                    celsiusSeekBar.progress = celsius - MIN_CELSIUS
                    temperatureCelsiusTextView.text = "$celsius"
                    temperatureFahrenheitTextView.text = "$fahrenheit"
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    // Convert Celsius to Fahrenheit
    fun celsiusToFahrenheit(celsius: Int): Int {
        return (celsius * 9 / 5) + 32
    }

    // Convert Fahrenheit to Celsius
    fun fahrenheitToCelsius(fahrenheit: Int): Int {
        return (fahrenheit - 32) * 5 / 9
    }
}