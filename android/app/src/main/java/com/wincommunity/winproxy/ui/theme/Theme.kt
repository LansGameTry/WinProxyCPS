package com.wincommunity.winproxy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val CyanPrimary = Color(0xFF00E5FF)
val CyanVariant = Color(0xFF00B0FF)
val PurpleLiquid = Color(0xFF8B5CF6)
val NeonGreen = Color(0xFF10B981)

val DarkBackground = Color(0xFF030712)
val GlassSurface = Color(0x8C0F172A)
val GlassBorder = Color(0x33FFFFFF)
val GlassHighlight = Color(0x55FFFFFF)

val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFF94A3B8)
val RedError = Color(0xFFFF5252)

private val DarkColorScheme = darkColorScheme(
    primary = CyanPrimary,
    secondary = NeonGreen,
    background = DarkBackground,
    surface = GlassSurface,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun WinProxyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
