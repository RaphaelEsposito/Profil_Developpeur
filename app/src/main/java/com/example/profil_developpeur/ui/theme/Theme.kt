package com.example.profil_developpeur.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = OnBlue40,
    primaryContainer = BlueContainer90,
    onPrimaryContainer = OnBlueContainer10,
    secondary = Teal40,
    onSecondary = OnBlue40,
    secondaryContainer = TealContainer90,
    onSecondaryContainer = OnTealContainer10,
    tertiary = Orange40,
    onTertiary = OnBlue40,
    tertiaryContainer = OrangeContainer90,
    onTertiaryContainer = OnOrangeContainer10,
    background = Neutral99,
    onBackground = Neutral10,
    surface = Neutral99,
    onSurface = Neutral10,
    surfaceVariant = NeutralVariant90,
    onSurfaceVariant = NeutralVariant30,
    outline = NeutralVariant50
)

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = OnBlue20,
    primaryContainer = BlueContainer30,
    onPrimaryContainer = OnBlueContainer90,
    secondary = Teal80,
    onSecondary = OnTealContainer10,
    secondaryContainer = TealContainer30,
    onSecondaryContainer = OnTealContainer90,
    tertiary = Orange80,
    onTertiary = OnOrangeContainer10,
    tertiaryContainer = OrangeContainer30,
    onTertiaryContainer = OnOrangeContainer90,
    background = Neutral6,
    onBackground = Neutral90,
    surface = Neutral6,
    onSurface = Neutral90,
    surfaceVariant = NeutralVariant30,
    onSurfaceVariant = NeutralVariant80,
    outline = NeutralVariant60
)

/**
 * Thème de l'application.
 *
 * Les couleurs dynamiques (Android 12+) sont désactivées par défaut pour garder
 * une identité visuelle propre à l'application, identique sur tous les appareils.
 */
@Composable
fun ProfilDéveloppeurTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}