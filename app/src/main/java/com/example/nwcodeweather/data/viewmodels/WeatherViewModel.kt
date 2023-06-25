package com.example.nwcodeweather.data.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nwcodeweather.data.models.WeatherForecast
import com.example.nwcodeweather.data.models.WeatherToday
import com.example.nwcodeweather.data.repository.WeatherRepository
import com.example.nwcodeweather.data.resources.WeatherResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
    ) : ViewModel() {
    data class Weather(
        val today: WeatherToday,
        val forecast: WeatherForecast
    )

    private val _weather = mutableStateOf<WeatherResource<Weather>>(WeatherResource.Loading)
    val weather: State<WeatherResource<Weather>> = _weather

    init {
        viewModelScope.launch {
            try {
                val todayWeather = async { weatherRepository.getTodayWeather() }
                val forecastWeather = async { weatherRepository.getWeatherForecast() }

                if (todayWeather.await() is WeatherResource.Success && forecastWeather.await() is WeatherResource.Success) {
                    _weather.value = WeatherResource.Success(
                        Weather(
                            (todayWeather.await() as WeatherResource.Success).data,
                            (forecastWeather.await() as WeatherResource.Success).data
                        )
                    )
                } else {
                    _weather.value = WeatherResource.Error("Failed to get weather")
                }
            } catch (e: Exception) {
                _weather.value = WeatherResource.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}