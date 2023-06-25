package com.example.nwcodeweather.utils.api

import com.example.nwcodeweather.R

enum class City(
    val title: Int,
    val latitude: Double,
    val longitude: Double
) {
    SAINT_PETERSBURG(
        title = R.string.saint_petersburg_city,
        latitude = 59.93,
        longitude = 30.33
    )
}