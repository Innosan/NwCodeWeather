package com.example.nwcodeweather.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherByHour(
    val dt: Int,
    val main: MainForecast,
    val weather: List<WeatherData>,
    val clouds: Clouds,
    val wind: Wind,
    val visibility: Int,
    val rain: Rain? = null,
    val snow: Snow? = null,
    val pop: Double,
    val sys: SysForecast,

    @SerialName("dt_txt") val dtTxt: String
)
