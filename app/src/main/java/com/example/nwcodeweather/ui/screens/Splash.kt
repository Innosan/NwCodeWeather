package com.example.nwcodeweather.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.example.nwcodeweather.ui.screens.destinations.HomeDestination
import com.example.nwcodeweather.ui.screens.destinations.SplashDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@RootNavGraph(start = true)
@Destination
@Composable
fun Splash(
    navigator: DestinationsNavigator,
    weatherViewModel: WeatherViewModel
) {
    LaunchedEffect(key1 = true) {
        delay(500)

        navigator.navigate(HomeDestination) {
            popUpTo(SplashDestination.route) {
                inclusive = true
            }
        }
    }

    Text(text = "Splash!")
}