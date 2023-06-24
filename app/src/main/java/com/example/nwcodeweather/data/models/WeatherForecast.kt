package com.example.nwcodeweather.data.models

import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecast(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherByHour>,
    val city: WeatherCity,
)
