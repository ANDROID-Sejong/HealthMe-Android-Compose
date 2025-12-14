package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_password.PasswordState
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun PasswordInputField(
    label: String,
    onValueChange: (String) -> Unit,
    isSatisfyPasswordRule: PasswordState
) {
    var inputText by remember { mutableStateOf("") }
    //var isValid by remember { mutableStateOf(false) }


    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            label,
            modifier = Modifier.padding(start = 17.dp),
            color = AppColors.white,
            fontSize = 16.sp,
            fontFamily = AppFonts.gmarketSans
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(
                    color = if (isSatisfyPasswordRule == PasswordState.UNSATISFY) AppColors.passwordNotMatchColor else AppColors.white,
                    shape = RoundedCornerShape(34.dp)
                )
                .border(
                    width = 3.dp,
                    color = if (isSatisfyPasswordRule == PasswordState.UNSATISFY) AppColors.passwordNotMatchBorder else AppColors.bigButtonColor,
                    shape = RoundedCornerShape(34.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = inputText,//inputText
                onValueChange = {
                    inputText = it
                    onValueChange(it) //외부 콜백에 전달
                },
                modifier = Modifier
                    .padding(start = 17.dp)
                    .weight(1f),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),//비밀번호 *로 뜨게
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                textStyle = TextStyle(fontSize = 17.sp)
            )

            Image(
                painter = if (isSatisfyPasswordRule == PasswordState.SATISFY) painterResource(R.drawable.password_check)
                else if (isSatisfyPasswordRule == PasswordState.NORMAL) painterResource(R.drawable.password_no_check)
                else painterResource(R.drawable.password_wrong_check),
                contentDescription = "비밀번호 체크",
                modifier = Modifier
                    //.align(Alignment.CenterEnd)
                    .padding(end = 22.dp)
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PasswordInputFieldPreview() {
    //PasswordInputField("비밀번호", onValueChange = ({ it }))
}

