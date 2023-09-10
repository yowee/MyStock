package com.yom.stocks.presentation.theme.ui

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = colorPrimary,
    secondary = colorAccent,
    error = colorRedError,
    background = darkBackgroundColor,
    surface = darkBackgroundColor,
    onPrimary = black,
    onSecondary = black,
    onError = black,
    onBackground = lightGray,
    onSurface = lightGray,
)

private val LightColorScheme = lightColorScheme(
    primary = colorPrimary,
    secondary = colorAccent,
    error = colorRedError,
    background = colorOffWhite,
    surface = colorOffWhite,
    onPrimary = black,
    onSecondary = black,
    onError = black,
    onBackground = black,
    onSurface = black,
)

@Composable
fun StocksTheme(content: @Composable () -> Unit) {
    val colorScheme = when {
        true && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isSystemInDarkTheme()) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        isSystemInDarkTheme() -> DarkColorScheme
        else -> {LightColorScheme}
    }
        MaterialTheme(
        colorScheme = colorScheme,
        typography = StocksTypography,
        shapes = StocksShapes,
        content = content
    )
}


//@Composable
//fun StocksTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
//}