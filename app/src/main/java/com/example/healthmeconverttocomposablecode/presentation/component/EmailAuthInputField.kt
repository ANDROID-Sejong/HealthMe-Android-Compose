package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.ui.AppFonts
import com.example.healthmeconverttocomposablecode.ui.AppColors

@Composable
fun EmailAuthInputField(label: String, placeholder: String,onClick : () -> Unit) {
    val inputText = remember { mutableStateOf("") }
    val isEnable = remember { mutableStateOf<Boolean>(false) }
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    isEnable.value = inputText.value.matches(emailRegex)



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
                value = inputText.value,//inputText
                onValueChange = { inputText.value = it },
                modifier = Modifier.padding(start = 17.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                ),//TextFieldColors(AppColors.placeholderColor),
                textStyle = TextStyle(fontSize = 17.sp)
            )
            Box(
                modifier = Modifier
                    .padding(end = 29.dp)
                    .size(width = 72.dp, height = 22.dp)
                    .clickable(enabled = isEnable.value, onClick = onClick)
                    .background(
                        color = if(isEnable.value)AppColors.authButtonColor else AppColors.authButtonDisableColor,
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
                    fontWeight = FontWeight.Medium,

                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun EmailAuthInputFieldPreview() {
    EmailAuthInputField("이메일", "Health1234@gmail.com",{})
}