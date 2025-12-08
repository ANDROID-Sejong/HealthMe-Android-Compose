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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.ui.AppFonts
import com.example.healthmeconverttocomposablecode.ui.theme.AppColors

@Composable
fun BigButton(text: String) {
    Box(
        modifier = Modifier
            .height(58.dp)
            .fillMaxWidth()
            .background(color = AppColors.buttonColor, shape = RoundedCornerShape(29.dp))
            .border(
                color = AppColors.buttonBorder,
                width = 2.dp,
                shape = RoundedCornerShape(29.dp)
            ), contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontFamily = AppFonts.gmarketSans, fontWeight = FontWeight.Bold, color = AppColors.textColor, fontSize = 17.sp)

    }

}

@Preview(showBackground = false)
@Composable
fun BigButtonPreview() {
    BigButton("로그인")
}