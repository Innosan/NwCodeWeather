package com.example.nwcodeweather.data.utils

object HttpRoutes {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5"

    const val TODAY_WEATHER = "$BASE_URL/weather"
    const val FORECAST = "$BASE_URL/forecast"
}