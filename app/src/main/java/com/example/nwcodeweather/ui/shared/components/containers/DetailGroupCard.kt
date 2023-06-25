package com.example.nwcodeweather.ui.shared.components.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailGroupCard(groupHeading: Int, content: @Composable () -> Unit) {
    Column() {
        Text(
            text = stringResource(id = groupHeading),
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Column(
            modifier = Modifier
                .background(Color.DarkGray.copy(.60f), RoundedCornerShape(14.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            content()
        }
    }
}