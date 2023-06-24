package com.example.nwcodeweather.data.models

import kotlinx.serialization.Serializable

@Serializable
data class WeatherToday (
    var coord: Coordinate,
    var weather: List<WeatherData>,
    var base: String,
    var main: Main,
    var visibility: Int,
    var wind: Wind,
    var rain: Rain? = null,
    var snow: Snow? = null,
    var clouds: Clouds,
    var dt: Int,
    var sys: Sys,
    var timezone: Int,
    var id: Int,
    var name: String,
    var cod: Int
)