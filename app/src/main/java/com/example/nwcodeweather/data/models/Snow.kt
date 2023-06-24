package com.example.nwcodeweather.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snow(
    @SerialName("1h") val oneHourVolume: Double? = null,
    @SerialName("3h") val threeHourVolume: Double? = null,
)
