package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun AuthCodeInputField(
    label: String,
    value: String,//입력한 인증코드 값
    onValueChange: (String) -> Unit,
    onResendClick: () -> Unit,
    onVerifyClick: () -> Unit,
    remainingTime: String//남은시간
) {
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
            TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.padding(start = 17.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                textStyle = TextStyle(fontSize = 17.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),

                )

            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                Text(
                    text = remainingTime,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = AppColors.countDownTextColor,
                    fontSize = 10.sp,
                    fontFamily = AppFonts.gmarketSans
                )
                Box(
                    modifier = Modifier
                        .padding(end = 2.dp, start = 5.dp)
                        .size(width = 35.dp, height = 22.dp)
                        .clickable(onClick = onVerifyClick)
                        .background(
                            color = AppColors.authButtonColor,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "인증",
                        fontFamily = AppFonts.gmarketSans,
                        fontSize = 8.sp,
                        color = AppColors.authTextColor,
                        fontWeight = FontWeight.Medium
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(end = 29.dp)
                        .size(width = 35.dp, height = 22.dp)
                        .clickable(onClick = onResendClick)
                        .background(
                            color = AppColors.authButtonColor,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "재전송",
                        fontFamily = AppFonts.gmarketSans,
                        fontSize = 8.sp,
                        color = AppColors.authTextColor,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AuthCodeInputFieldPreview() {
    AuthCodeInputField(
        "인증코드", "", {},//TODO 인증여부 반환
        {} //TODO 이메일 재전송 및 시간 초기화)
        , {},"05:00"
    )
}