package com.example.nwcodeweather.data.repository

import com.example.nwcodeweather.data.models.WeatherForecast
import com.example.nwcodeweather.data.models.WeatherToday
import com.example.nwcodeweather.data.resources.WeatherResource
import com.example.nwcodeweather.data.utils.HttpRoutes
import com.example.nwcodeweather.utils.api.City
import com.example.nwcodeweather.utils.api.Language
import com.example.nwcodeweather.utils.api.Units
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*

class WeatherRepository(
    private val client: HttpClient
) {
    suspend fun getTodayWeather() : WeatherResource<WeatherToday> {
        return try {
            val response =  client.get {
                url(HttpRoutes.TODAY_WEATHER)

                parameter("lat", City.SAINT_PETERSBURG.latitude)
                parameter("lon", City.SAINT_PETERSBURG.longitude)
                parameter("units", Units.METRIC.title)
                parameter("lang", Language.ENGLISH.title)
                parameter("appid", "d9e6fe2ca9bd114df14262b014663852")
            }

            if (response.status.isSuccess()) {
                WeatherResource.Success(response.body())
            } else {
                WeatherResource.Error("Failed to get today's weather")
            }
        } catch (e: Exception) {
            // Handles all other errors
            WeatherResource.Error(e.message ?: "Unknown error occurred!")
        }
    }

    suspend fun getWeatherForecast() : WeatherResource<WeatherForecast> {
        return try {
            val response = client.get {
               url(HttpRoutes.FORECAST)

               parameter("lat", City.SAINT_PETERSBURG.latitude)
               parameter("lon", City.SAINT_PETERSBURG.longitude)
               parameter("units", Units.METRIC.title)
               parameter("lang", Language.ENGLISH.title)
               parameter("appid", "d9e6fe2ca9bd114df14262b014663852")
            }

            if (response.status.isSuccess()) {
                WeatherResource.Success(response.body())
            } else WeatherResource.Error("Failed to get weather forecast!")
        } catch (e: Exception) {
            // Handles all other errors
            WeatherResource.Error(e.message ?: "Unknown error occurred!")
        }
    }
}