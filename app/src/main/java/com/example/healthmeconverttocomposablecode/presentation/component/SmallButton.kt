package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun SmallButton(
    text: String,
    backgroundColor: Color = AppColors.smallButtonColor,
    borderColor: Color = AppColors.smallButtonBorder,
    textColor: Color = AppColors.black,
    isEnableButton: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(31.dp)
            .background(
                color = if (isEnableButton) backgroundColor else AppColors.authButtonDisableColor,
                shape = RoundedCornerShape(22.dp)
            )
            .border(
                color = borderColor,
                width = 1.dp,
                shape = RoundedCornerShape(22.dp)
            )
            .clickable(onClick = {onClick()}),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = AppFonts.gmarketSans,
            fontWeight = FontWeight.Medium,
            color = textColor,
            fontSize = 13.sp,
            modifier = Modifier.padding(horizontal = 23.dp)
        )

    }

}

@Preview(showBackground = false)
@Composable
fun SmallButtonPreview() {
    SmallButton("로그인") {

    }
}