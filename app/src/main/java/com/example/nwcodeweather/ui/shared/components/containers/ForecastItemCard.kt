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
import com.example.nwcodeweather.data.models.WeatherByHour
import com.example.nwcodeweather.ui.shared.components.service.WebWeatherIcon
import com.example.nwcodeweather.utils.formatStringToDateTime

@Composable
fun ForecastItemCard(weather: WeatherByHour) {
    Row(
        modifier = Modifier
            .background(Color.White.copy(.35f), RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(12.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            val (date, time) = formatStringToDateTime(date = weather.dtTxt)

            Text(
                text = date,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White.copy(.7f),
                fontSize = 14.sp
            )
            Text(
                text = time,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            WebWeatherIcon(iconId = weather.weather[0].icon, contentDescription = "Weather icon")
            Text(
                text = "${weather.main.temp.toInt()} °C",
                fontWeight = FontWeight.Black,
                fontSize = 28.sp
            )
        }
    }
}