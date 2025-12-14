package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun MediumButton(
    text: String,
    backgroundColor: Color = AppColors.mediumButtonColor,
    borderColor: Color = AppColors.mediumButtonBorder,
    textColor: Color = AppColors.mediumButtonTextColor,
    isEnableButton: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(58.dp)
            .fillMaxWidth()
            .background(
                color = if (isEnableButton) backgroundColor else AppColors.authButtonDisableColor,
                shape = RoundedCornerShape(22.dp)
            )
            .border(
                color = borderColor,
                width = 3.dp,
                shape = RoundedCornerShape(22.dp)
            )
            .clickable(onClick = onClick, enabled = isEnableButton),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = AppFonts.gmarketSans,
            fontWeight = FontWeight.Medium,
            color = textColor,
            fontSize = 16.sp
        )

    }

}

@Preview(showBackground = false)
@Composable
fun MediumButtonPreview() {
    MediumButton("로그인") {

    }
}