package com.revature.project1pounds.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Red900,
    primaryVariant = Red700,
    secondary = Grey400,
    secondaryVariant = Grey300,
    background = Grey900,
    surface = Color.DarkGray,
    onPrimary = Grey400,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Grey400,
)

private val LightColorPalette = lightColors(
    primary = Red700,
    primaryVariant = Red900,
    secondary = Grey300,
    secondaryVariant = Grey400,
    background = Color.White,
    surface = Red400,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)


@Composable
fun Project1PoundsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    if(darkTheme){
        systemUiController.setStatusBarColor(DarkColorPalette.primary)
    }else{
        systemUiController.setStatusBarColor(
            color = LightColorPalette.primary
        )
    }
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}