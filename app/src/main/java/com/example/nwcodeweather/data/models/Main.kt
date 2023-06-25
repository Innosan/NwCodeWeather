package com.example.nwcodeweather.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main (
    var temp: Double,
    var pressure: Int,
    var humidity: Int,

    @SerialName("feels_like") val feelsLike: Double,
    @SerialName("temp_min") val tempMin: Double,
    @SerialName("temp_max") val tempMax: Double,
    @SerialName("sea_level") val seaLevel: Int = 0,
    @SerialName("grnd_level") val grndLevel: Int = 0
)

@Serializable
data class MainForecast (
    var temp: Double,
    var pressure: Int,
    var humidity: Int,

    @SerialName("feels_like") val feelsLike: Double,
    @SerialName("temp_min") val tempMin: Double,
    @SerialName("temp_max") val tempMax: Double,
    @SerialName("sea_level") val seaLevel: Int = 0,
    @SerialName("grnd_level") val grndLevel: Int = 0,
    @SerialName("temp_kf") val tempKf: Double
)
