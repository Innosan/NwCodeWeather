package com.example.nwcodeweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.nwcodeweather.data.models.WeatherForecast
import com.example.nwcodeweather.data.repository.WeatherRepository
import com.example.nwcodeweather.data.models.WeatherToday
import com.example.nwcodeweather.ui.screens.NavGraphs
import com.example.nwcodeweather.ui.theme.NwCodeWeatherTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch

private val repo = WeatherRepository(
    client = HttpClient(
        Android
    ) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
    }
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()

            val weatherToday = remember {
                mutableStateOf<WeatherToday?>(null)
            }

            val weatherForecast = remember {
                mutableStateOf<WeatherForecast?>(null)
            }

            NwCodeWeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    scope.launch {
                        weatherToday.value = repo.getTodayWeather()
                        weatherForecast.value = repo.getWeatherForecast()
                    }
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}