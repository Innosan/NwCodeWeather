package com.example.nwcodeweather.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nwcodeweather.R
import com.example.nwcodeweather.ui.screens.destinations.HomeDestination
import com.example.nwcodeweather.ui.screens.destinations.SplashDestination
import com.example.nwcodeweather.utils.isNetworkAvailable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@RootNavGraph(start = true)
@Destination
@Composable
fun Splash(
    navigator: DestinationsNavigator,
) { 
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        delay(500)

        if (isNetworkAvailable(context)) {
            navigator.navigate(HomeDestination) {
                popUpTo(SplashDestination.route) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_launcher), contentDescription = "App icon")

            CircularProgressIndicator()

            if (!isNetworkAvailable(context)) {
                Text(text = "Network is not available!")
            }
        }
    }
}