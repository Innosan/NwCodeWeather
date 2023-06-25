package com.example.nwcodeweather.data.resources

sealed class WeatherResource<out T> {
    data class Success<out T>(val data: T) : WeatherResource<T>()
    data class Error(val message: String) : WeatherResource<Nothing>()

    object Loading : WeatherResource<Nothing>()
}
