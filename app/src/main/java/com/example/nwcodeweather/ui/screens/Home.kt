package com.example.nwcodeweather.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Home(
    navigator: DestinationsNavigator,
    viewModel: WeatherViewModel
) {
    val today = viewModel.weather.value.today

    Column {
        Text(text = today?.main?.temp.toString())
        Text(text = today?.main?.feelsLike.toString())
        Text(text = today?.main?.tempMax.toString())
    }
}