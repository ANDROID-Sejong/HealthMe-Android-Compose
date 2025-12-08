package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.ui.AppFonts
import com.example.healthmeconverttocomposablecode.ui.theme.AppColors
import com.example.healthmeconverttocomposablecode.ui.theme.AppColors.buttonColor

@Composable
fun BigButton(
    text: String,
    backgroundColor: Color = AppColors.buttonColor,
    borderColor: Color = AppColors.buttonBorder,
    textColor: Color = AppColors.textColor
) {
    Box(
        modifier = Modifier
            .height(58.dp)
            .fillMaxWidth()
            .background(color = backgroundColor, shape = RoundedCornerShape(29.dp))
            .border(
                color = borderColor,
                width = 2.dp,
                shape = RoundedCornerShape(29.dp)
            ), contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = AppFonts.gmarketSans,
            fontWeight = FontWeight.Bold,
            color = textColor,
            fontSize = 17.sp
        )

    }

}

@Preview(showBackground = false)
@Composable
fun BigButtonPreview() {
    BigButton("로그인")
}