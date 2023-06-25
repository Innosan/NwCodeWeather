package com.example.nwcodeweather.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nwcodeweather.R
import com.example.nwcodeweather.data.models.WeatherToday
import com.example.nwcodeweather.data.resources.WeatherResource
import com.example.nwcodeweather.data.viewmodels.WeatherViewModel
import com.example.nwcodeweather.ui.shared.components.containers.DetailGroupCard
import com.example.nwcodeweather.ui.shared.components.containers.DetailWithIcon
import com.example.nwcodeweather.ui.shared.components.containers.ScreenContainer
import com.example.nwcodeweather.ui.shared.styles.subTextStyle
import com.example.nwcodeweather.utils.unixTimeToDateTime
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalLayoutApi::class)
@Destination
@Composable
fun Details(
    weatherViewModel: WeatherViewModel
) {
    ScreenContainer(contentSpacing = 24) {
        when (val weatherResource = weatherViewModel.weather.value) {
            is WeatherResource.Success -> {
                val weather = weatherResource.data.today

                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${weather.main.temp.toInt()} °C",
                        fontSize = 56.sp,
                        fontWeight = FontWeight.Black
                    )

                    Text(
                        text = stringResource(
                            id = R.string.feels_like_title
                        ) + " ${weather.main.temp.toInt()} °C",

                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White.copy(.8f)
                    )
                }

                Text(
                    text = weather.weather[0].description.uppercase(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White.copy(.40f), RoundedCornerShape(12.dp))
                        .padding(12.dp),

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DetailWithIcon(
                        icon = R.drawable.ic_clouds,
                        iconSize = 26,
                        detailText = "${weather.clouds.all}%"
                    )
                    DetailWithIcon(
                        icon = R.drawable.ic_humidity,
                        iconSize = 26,
                        detailText = "${weather.main.humidity}%"
                    )
                    DetailWithIcon(
                        icon = R.drawable.ic_visibility,
                        iconSize = 26,
                        detailText = "${weather.visibility / 1000} km"
                    )
                }

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    DetailGroupCard(groupHeading = R.string.temperature_heading) {
                        DetailWithIcon(
                            icon = R.drawable.ic_min_temp,
                            detailText = "${weather.main.tempMin.toInt()} °C"
                        )
                        DetailWithIcon(
                            icon = R.drawable.ic_max_temp,
                            detailText = "${weather.main.tempMax.toInt()} °C"
                        )
                    }

                    DetailGroupCard(groupHeading = R.string.day_heading) {
                        val sunset = unixTimeToDateTime(weather.sys.sunset.toLong())
                        val sunrise = unixTimeToDateTime(weather.sys.sunrise.toLong())

                        DetailWithIcon(
                            icon = R.drawable.ic_sunset,
                            detailText = sunset
                        )
                        DetailWithIcon(
                            icon = R.drawable.ic_sunrise,
                            detailText = sunrise
                        )
                    }

                    DetailGroupCard(groupHeading = R.string.wind_heading) {
                        DetailWithIcon(
                            icon = R.drawable.ic_wind,
                            iconSize = 20,
                            detailText = "${weather.wind.speed} m/s"
                        )
                        DetailWithIcon(
                            icon = R.drawable.ic_wind_direction,
                            detailText = "${weather.wind.deg}°"
                        )

                        Text(
                            text = "Gust - ${weather.wind.gust} m/s",
                            style = subTextStyle,
                        )
                    }

                    DetailGroupCard(groupHeading = R.string.pressure_heading) {
                        DetailWithIcon(
                            icon = R.drawable.ic_pressure,
                            iconSize = 20,
                            detailText = "${weather.main.pressure} mmHg"
                        )

                        Text(
                            text = "Sea - ${weather.main.seaLevel}",
                            style = subTextStyle,
                        )
                        Text(
                            text = "Ground - ${weather.main.grndLevel}",
                            style = subTextStyle,
                        )
                    }
                }
            }
            is WeatherResource.Error -> {
                val errorMessage = weatherResource.message

                Text(text = errorMessage)
            }
            is WeatherResource.Loading -> {
                CircularProgressIndicator()
            }
        }
    }
}