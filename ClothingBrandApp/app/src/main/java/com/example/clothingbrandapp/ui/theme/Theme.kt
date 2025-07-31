package com.example.clothingbrandapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light Theme Colors
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4F46E5),       // Indigo 600
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE0E7FF),

    secondary = Color(0xFF6366F1),     // Indigo 500
    onSecondary = Color.White,

    background = Color(0xFFF9FAFB),
    onBackground = Color(0xFF1F2937),

    surface = Color.White,
    onSurface = Color(0xFF111827),

    error = Color(0xFFEF4444),
    onError = Color.White
)

@Composable
fun ClothingBrandAppTheme(
    darkTheme: Boolean = false, // Set to false to force light mode
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography(),
        content = content
    )
}
