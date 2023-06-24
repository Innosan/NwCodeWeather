package com.example.nwcodeweather.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Sys (
    var type: Int,
    var id: Int,
    var country: String,
    var sunrise: Int,
    var sunset: Int
)

@Serializable
data class SysForecast (
    var pod: String
)
