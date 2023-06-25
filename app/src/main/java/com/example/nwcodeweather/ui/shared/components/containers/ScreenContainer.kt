package com.example.nwcodeweather.ui.shared.components.containers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nwcodeweather.R

@Composable
fun ScreenContainer(
    contentSpacing: Int = 14,
    showBackground: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = listOf(Color.Black.copy(.7f), MaterialTheme.colorScheme.background)

    val brush = Brush.verticalGradient(
        colors,
    )

    Box {
        if (showBackground) {
            Image(
                painter = painterResource(id = R.drawable.bg_app),
                contentDescription = "Screen background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize(),
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(contentSpacing.dp)
            ) {
                content()
            }
        }
    }
}