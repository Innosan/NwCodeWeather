package com.example.nwcodeweather.data.repository

import com.example.nwcodeweather.data.models.WeatherForecast
import com.example.nwcodeweather.data.models.WeatherToday
import com.example.nwcodeweather.data.utils.HttpRoutes
import com.example.nwcodeweather.utils.api.City
import com.example.nwcodeweather.utils.api.Language
import com.example.nwcodeweather.utils.api.Units
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class WeatherRepository(
    private val client: HttpClient
) {
    suspend fun getTodayWeather() : WeatherToday {
        val response = client.get {
            url(HttpRoutes.TODAY_WEATHER)

            parameter("lat", City.SAINT_PETERSBURG.latitude)
            parameter("lon", City.SAINT_PETERSBURG.longitude)
            parameter("units", Units.METRIC.title)
            parameter("lang", Language.RUSSIAN.title)
            parameter("appid", "d9e6fe2ca9bd114df14262b014663852")
        }.body<WeatherToday>()

        println(response)

        return response
    }

    suspend fun getWeatherForecast() : WeatherForecast {
        val response = client.get {
            url(HttpRoutes.FORECAST)

            parameter("lat", City.SAINT_PETERSBURG.latitude)
            parameter("lon", City.SAINT_PETERSBURG.longitude)
            parameter("units", Units.METRIC.title)
            parameter("lang", Language.RUSSIAN.title)
            parameter("appid", "d9e6fe2ca9bd114df14262b014663852")
        }.body<WeatherForecast>()

        println(response)

        return response
    }
}