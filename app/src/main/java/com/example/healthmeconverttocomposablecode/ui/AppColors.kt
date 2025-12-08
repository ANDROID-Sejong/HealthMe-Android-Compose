package com.example.healthmeconverttocomposablecode.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object AppColors {
    val mainColor = Color(0xff6A73FF)
    val white = Color(0xffffffff)
    val black = Color(0xff000000)

    val buttonColor = Color(0xffE4FF3E)
    val buttonBorder = Color(0xff9BB400)

    val textColor = Color(0xff409100)

    val startColor = Color(0xFFF3FFFB) // F3FFFB
    val endColor = Color(0xFFB8FFEA)   // B8FFEA

    val firstScreenTextBrush = Brush.verticalGradient(
        colors = listOf(startColor, endColor),
        startY =0f,
        endY =Float.POSITIVE_INFINITY
    )
}