package com.example.healthmeconverttocomposablecode.ui

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object AppColors {
    val mainColor = Color(0xff6A73FF)
    val white = Color(0xffffffff)
    val black = Color(0xff000000)

    val bigButtonColor = Color(0xffE4FF3E)
    val bigButtonBorder = Color(0xff9BB400)
    val mediumButtonColor = Color(0xffE4FF3E)
    val mediumButtonBorder = Color(0xff718300)

    val bigButtonTextColor = Color(0xff409100)
    val mediumButtonTextColor = Color(0xff6D7F00)

    val passwordNotMatchColor = Color(0xffFFD7D7)
    val passwordNotMatchBorder = Color(0xffFF7F7F)

    val red = Color(0xffff0000)

    val startColor = Color(0xFFF3FFFB) // F3FFFB
    val endColor = Color(0xFFB8FFEA)   // B8FFEA

    val firstScreenTextBrush = Brush.verticalGradient(
        colors = listOf(startColor, endColor),
        startY =0f,
        endY =Float.POSITIVE_INFINITY
    )

    val placeholderColor = Color(0xffB8B8B8)
}