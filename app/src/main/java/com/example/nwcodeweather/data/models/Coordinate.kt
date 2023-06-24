package com.example.nwcodeweather.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Coordinate (
    var lon: Double,
    var lat: Double
)
