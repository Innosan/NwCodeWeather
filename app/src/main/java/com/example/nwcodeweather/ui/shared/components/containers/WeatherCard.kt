package com.example.nwcodeweather.ui.shared.components.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nwcodeweather.data.models.WeatherToday
import com.example.nwcodeweather.ui.shared.components.service.WebWeatherIcon

@Composable
fun WeatherCard(weather: WeatherToday) {
    val actualWeather = weather.weather[0]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.White.copy(.35f), RoundedCornerShape(14.dp)),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        WebWeatherIcon(iconId = actualWeather.icon, contentDescription = actualWeather.description)
        
        Text(
            text = "${weather.main.temp.toInt()}°C",
            fontSize = 48.sp,
            fontWeight = FontWeight.Companion.Black,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}