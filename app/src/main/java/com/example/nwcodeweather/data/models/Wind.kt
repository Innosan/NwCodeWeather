package com.example.nwcodeweather.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Wind (
    var speed: Double,
    var deg: Int,
    var gust: Double = 0.0
)
