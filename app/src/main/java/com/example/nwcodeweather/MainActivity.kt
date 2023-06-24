package com.example.nwcodeweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.example.nwcodeweather.ui.screens.Home
import com.example.nwcodeweather.ui.screens.NavGraphs
import com.example.nwcodeweather.ui.screens.Splash
import com.example.nwcodeweather.ui.screens.destinations.HomeDestination
import com.example.nwcodeweather.ui.screens.destinations.SplashDestination
import com.example.nwcodeweather.ui.theme.NwCodeWeatherTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NwCodeWeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                    ) {
                        composable(HomeDestination) {
                            Home(
                                navigator = destinationsNavigator,
                                viewModel = weatherViewModel
                            )
                        }
                        composable(SplashDestination) {
                            Splash(
                                navigator = destinationsNavigator,
                                weatherViewModel = weatherViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}