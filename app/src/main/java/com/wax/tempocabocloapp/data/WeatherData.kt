package com.wax.tempocabocloapp.data

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

sealed class WeatherData

data class CurrentLocation(
    val date: String = getCurrentDate(),
    val location: String = "Choose your location",
    val latitude: Double? = null,
    val longitude: Double? = null
) : WeatherData()

data class CurrentWeather(
    val icon: String,
    val temperature: Float,
    val wind: Float,
    val humidity: Float,
    val chanceOfRain: Int
): WeatherData()

data class Forecast(
    val time: String,
    val icon: String,
    val temperature: Float,
    val feelsLikeTemperature: Float
): WeatherData()

private fun getCurrentDate(): String {
    val currentData = Date()
    val formatter = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
    return "Today, ${formatter.format(currentData)}"
}