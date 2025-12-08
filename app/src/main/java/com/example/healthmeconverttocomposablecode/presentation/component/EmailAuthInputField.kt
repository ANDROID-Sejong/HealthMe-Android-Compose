package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.healthmeconverttocomposablecode.ui.AppColors

@Composable
fun EmailAuthInputField(label: String, placeholder: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            label,
            modifier = Modifier.padding(start = 17.dp),
            color = AppColors.white,
            fontSize = 17.sp,
            fontFamily = AppFonts.gmarketSans
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(
                    color = AppColors.white,
                    shape = RoundedCornerShape(34.dp)
                )
                .border(
                    width = 3.dp,
                    color = AppColors.bigButtonColor,
                    shape = RoundedCornerShape(34.dp)
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = placeholder,
                modifier = Modifier.padding(start = 17.dp),
                color = AppColors.placeholderColor,
                fontSize = 17.sp
            )
            Box(
                modifier = Modifier
                    .padding(end = 29.dp)
                    .size(width = 72.dp, height = 22.dp)
                    .background(
                        color = AppColors.authButtonColor,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .align(Alignment.CenterEnd),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "인증코드 발송",
                    modifier = Modifier,
                    fontFamily = AppFonts.gmarketSans,
                    fontSize = 8.sp,
                    color = AppColors.authTextColor,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun EmailAuthInputFieldPreview() {
    EmailAuthInputField("이메일", "Health1234@gmail.com")
}