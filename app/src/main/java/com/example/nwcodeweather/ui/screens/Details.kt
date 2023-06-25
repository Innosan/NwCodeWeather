package com.example.nwcodeweather.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(style = DestinationStyle.Dialog::class)
@Composable
fun Details(
    weatherViewModel: WeatherViewModel
) {
    val weather = weatherViewModel.weather.value.today

    Text(text = "Weather details")
}