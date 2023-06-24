package com.example.nwcodeweather.ui.shared.components.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MiscWeatherInfoCard(icon: Int, miscInfo: String) {
    Column(
        modifier = Modifier
            .background(Color.DarkGray.copy(.4f), RoundedCornerShape(16.dp))
            .padding(12.dp),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "Misc icon")

        Text(
            text = miscInfo,
            fontWeight = FontWeight.ExtraBold
        )
    }
}