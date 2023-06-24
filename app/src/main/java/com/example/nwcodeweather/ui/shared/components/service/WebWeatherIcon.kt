package com.example.nwcodeweather.ui.shared.components.service

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun WebWeatherIcon(iconId: String, contentDescription: String) {
    val fullPath = "https://openweathermap.org/img/wn/$iconId@4x.png"

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(fullPath)
            .crossfade(true)
            .build(),

        contentDescription = "$contentDescription icon",
    )
}