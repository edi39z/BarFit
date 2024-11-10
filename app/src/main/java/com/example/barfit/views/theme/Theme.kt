package com.example.barfit.views.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val lightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    background = Color.White,
    surface = Color.White,
)

@Composable
fun BarFitTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColors,
        content = content
    )
}
