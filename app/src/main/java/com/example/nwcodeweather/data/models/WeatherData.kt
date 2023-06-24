package com.example.nwcodeweather.data.models

import kotlinx.serialization.Serializable

@Serializable
data class WeatherData (
    var id: Int,
    var main: String,
    var description: String,
    var icon: String
)