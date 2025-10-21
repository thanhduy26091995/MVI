package com.densitech.mvi.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = Color.White,
    primaryContainer = PrimaryLightColor,
    onPrimaryContainer = PrimaryDarkColor,

    secondary = SecondaryColor,
    onSecondary = Color.Black,
    secondaryContainer = SecondaryLightColor,
    onSecondaryContainer = SecondaryDarkColor,

    background = PrimaryBackgroundColor,
    onBackground = NeutralBlackColor,

    surface = NeutralWhiteColor,
    onSurface = NeutralBlackColor,

    error = ErrorBaseColor,
    onError = Color.White,
    errorContainer = ErrorLightColor,
    onErrorContainer = ErrorDarkColor,

    tertiary = SuccessBaseColor,
    onTertiary = Color.White,
    tertiaryContainer = SuccessLightColor,
    onTertiaryContainer = SuccessDarkColor,
    outline = NeutralBaseGreyColor
)

private val DarkColors = darkColorScheme(
    primary = PrimaryLightColor,
    onPrimary = PrimaryDarkColor,
    primaryContainer = PrimaryDarkColor,
    onPrimaryContainer = PrimaryLightColor,

    secondary = SecondaryLightColor,
    onSecondary = SecondaryDarkColor,
    secondaryContainer = SecondaryDarkColor,
    onSecondaryContainer = SecondaryLightColor,

    background = Color(0xFF121212),
    onBackground = NeutralWhiteColor,

    surface = Color(0xFF1E1E1E),
    onSurface = NeutralWhiteColor,

    error = ErrorBaseColor,
    onError = Color.White,
    errorContainer = ErrorDarkColor,
    onErrorContainer = ErrorLightColor,

    tertiary = SuccessLightColor,
    onTertiary = SuccessDarkColor,
    tertiaryContainer = SuccessDarkColor,
    onTertiaryContainer = SuccessLightColor,

    outline = NeutralDarkGreyColor
)


@Composable
fun MVITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}