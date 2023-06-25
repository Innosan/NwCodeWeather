package com.example.nwcodeweather.ui.shared.components.service

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.nwcodeweather.ui.shared.styles.buttonTextStyle

/**
 * A composable function that displays a button with the specified text and width fraction.
 *
 * @param buttonText The resource ID of the text to be displayed in the button.
 * @param fraction The fraction of the screen width that the button should occupy.
 * @param onClick The navigation function to be executed when the button is clicked.
 */
@Composable
fun NavigateButton(
    buttonText: Int,
    fraction: Float,
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth(fraction),
    ) {
        Text(
            text = stringResource(id = buttonText).uppercase(),
            style = buttonTextStyle
        )
    }
}