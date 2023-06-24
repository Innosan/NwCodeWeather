package com.example.nwcodeweather.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Home(
    navigator: DestinationsNavigator
) {
    Text(text = "Hello, world!")
}