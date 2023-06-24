package com.example.nwcodeweather.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.example.nwcodeweather.ui.shared.components.containers.ScreenContainer
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun Forecast(
    weatherViewModel: WeatherViewModel
) {
    val forecast = weatherViewModel.weather.value.forecast

    ScreenContainer() {
        if (forecast != null) {
            Text(text = forecast.city.name)
        }
    }
}