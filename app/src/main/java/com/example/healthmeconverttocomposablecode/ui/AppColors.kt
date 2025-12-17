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
    val mediumButtonDisableBorder = Color(0xffA8A8A8)

    val smallButtonColor = Color(0xffE4FF3E)
    val smallButtonBorder = Color(0xff718300)

    val agreeTermsButtonColor = Color(0xffEEFF87)
    val agreeTermsButtonTextColor = Color(0xff9DA56A)


    val bigButtonTextColor = Color(0xff409100)
    val mediumButtonTextColor = Color(0xff6D7F00)

    val passwordNotMatchColor = Color(0xffFFD7D7)
    val passwordNotMatchBorder = Color(0xffFF7F7F)

    val authButtonColor = Color(0xffDBFF00)
    val authButtonDisableColor = Color(0xffDADADA)
    val authTextColor = Color(0xff829800)

    val countDownTextColor = Color(0xffAFAFAF)

    val red = Color(0xffff0000)

    val startColor = Color(0xFFF3FFFB) // F3FFFB
    val endColor = Color(0xFFB8FFEA)   // B8FFEA

    val firstScreenTextBrush = Brush.verticalGradient(
        colors = listOf(startColor, endColor),
        startY =0f,
        endY =Float.POSITIVE_INFINITY
    )

    val placeholderColor = Color(0xffB8B8B8)
    val informationInputFieldUnitTextColor = Color(0xff9D9D9D)
}