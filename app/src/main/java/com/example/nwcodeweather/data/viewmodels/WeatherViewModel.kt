package com.example.nwcodeweather.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nwcodeweather.data.models.WeatherForecast
import com.example.nwcodeweather.data.models.WeatherToday
import com.example.nwcodeweather.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(weatherRepository: WeatherRepository) : ViewModel() {
    data class Weather(
        val today: WeatherToday?,
        val forecast: WeatherForecast?
    )

    private val _weather = mutableStateOf(
        Weather(
            null,
            null
        )
    )
    val weather = _weather

    init {
        viewModelScope.launch {
            try {
                val todayWeather = async { weatherRepository.getTodayWeather() }
                val forecastWeather = async { weatherRepository.getWeatherForecast() }

                _weather.value = Weather(
                    todayWeather.await(),
                    forecastWeather.await()
                )
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}