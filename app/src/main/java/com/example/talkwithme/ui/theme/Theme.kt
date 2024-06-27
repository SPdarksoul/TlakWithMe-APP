package com.example.talkwithme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val DarkColorScheme = darkColorScheme(
    primary = Green,
    secondary = Green,
    background = LightGray,
    tertiary = White
)

private val LightColorScheme = lightColorScheme(
    primary = lightGreen,
    secondary = Green,
    background = Green,
    tertiary = White
)

@Composable
fun TalkWithMeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        lightColorScheme()
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        val systemUiController = rememberSystemUiController()
        val statusBarColor = if (darkTheme) {
Green
        } else {
lightGreen   }
        val navigationBarColor = if (darkTheme) {
            Green
        } else {
lightGreen
        }
        SideEffect {
            systemUiController.setStatusBarColor(
                color = statusBarColor
            )
            systemUiController.setNavigationBarColor(
                color = navigationBarColor
            )
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
