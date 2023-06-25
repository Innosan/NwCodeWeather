package com.example.nwcodeweather.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.nwcodeweather.R
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.example.nwcodeweather.ui.screens.destinations.HomeDestination
import com.example.nwcodeweather.ui.shared.components.containers.ForecastItemCard
import com.example.nwcodeweather.ui.shared.components.containers.ScreenContainer
import com.example.nwcodeweather.ui.shared.components.service.NavigateButton
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Forecast(
    navigator: DestinationsNavigator,
    weatherViewModel: WeatherViewModel
) {
    val forecast = weatherViewModel.weather.value.forecast

    ScreenContainer(contentSpacing = 24) {
        if (forecast != null) {
            Text(text = forecast.city.name)

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.75f)
                    .clip(RoundedCornerShape(10.dp)),

                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(forecast.list, key = { weather -> weather.dt }) { weather ->
                    ForecastItemCard(weather = weather)
                }
            }
            
            NavigateButton(buttonText = R.string.home_button, fraction = 1f) {
                navigator.navigate(HomeDestination)
            }
        }
    }
}