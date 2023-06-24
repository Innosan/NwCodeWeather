package com.example.nwcodeweather.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nwcodeweather.R
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.example.nwcodeweather.ui.screens.destinations.DetailsDestination
import com.example.nwcodeweather.ui.screens.destinations.ForecastDestination
import com.example.nwcodeweather.ui.shared.components.containers.MiscWeatherInfoCard
import com.example.nwcodeweather.ui.shared.components.containers.ScreenContainer
import com.example.nwcodeweather.ui.shared.components.containers.WeatherCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Home(
    navigator: DestinationsNavigator,
    weatherViewModel: WeatherViewModel
) {
    val todayWeather = weatherViewModel.weather.value.today

    ScreenContainer {
        Text(
            text = stringResource(id = R.string.saint_petersburg_city).uppercase(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Black,
            fontSize = 28.sp
        )

        if (todayWeather != null) {
            WeatherCard(weather = todayWeather)

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MiscWeatherInfoCard(
                    icon = R.drawable.ic_humidity,
                    miscInfo = "${todayWeather.main.humidity} %"
                )
                MiscWeatherInfoCard(
                    icon = R.drawable.ic_wind,
                    miscInfo = "${todayWeather.wind.speed} m/s"
                )
                MiscWeatherInfoCard(
                    icon = R.drawable.ic_pressure,
                    miscInfo = "${todayWeather.main.pressure} hPa"
                )
            }

            Row() {
                Button(onClick = { navigator.navigate(DetailsDestination) }) {
                    Text(text = "Details")
                }
                Button(onClick = { navigator.navigate(ForecastDestination) }) {
                    Text(text = "Forecast")
                }
            }
        }
    }
}