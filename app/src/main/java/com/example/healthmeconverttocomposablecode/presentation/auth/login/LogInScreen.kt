package com.example.healthmeconverttocomposablecode.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.presentation.component.InputField
import com.example.healthmeconverttocomposablecode.presentation.component.MediumButton
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun LoginScreen(onLoginButtonClick: () -> Unit) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = AppColors.mainColor)
                .padding(horizontal = 25.dp), verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(164.dp))
            Text(
                "Log In",
                modifier = Modifier.padding(start = 14.dp),
                fontFamily = AppFonts.gmarketSans,
                fontSize = 32.sp,
                color = AppColors.white,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(71.dp))
            InputField(label = "이메일", placeholder = "Health1234@gmail.com")
            Spacer(modifier = Modifier.height(32.dp))
            InputField(label = "비밀번호", placeholder = "")
            Spacer(Modifier.height(14.dp))
            Text(
                "비밀번호를 잊으셨나요?",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = AppFonts.gmarketSans,
                color = AppColors.white,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(10.dp))
            Box( //TODO 나중에 이거 비밀번호 틀렸을 때만 나오게 수정할 것
                modifier = Modifier
                    .height(27.dp)
                    .padding(horizontal = 21.dp)
                    .fillMaxWidth()
                    .background(
                        color = AppColors.passwordNotMatchColor,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(
                        color = AppColors.passwordNotMatchBorder,
                        width = 1.dp,
                        shape = RoundedCornerShape(10.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Text(
                    "아이디 또는 비밀번호가 일치하지 않습니다.",
                    modifier = Modifier,
                    fontFamily = AppFonts.gmarketSans,
                    color = AppColors.red,
                    fontSize = 9.sp,
                )
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp), horizontalArrangement = Arrangement.Center
            ) {
                MediumButton("로그인") {
                    onLoginButtonClick()
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.padding(start = 76.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(11.dp)
                        .border(
                            width = 1.dp,
                            color = AppColors.white,
                            shape = RoundedCornerShape(3.dp)
                        )
                ) {

                }
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    "로그인 유지하기",
                    modifier = Modifier,
                    fontSize = 10.sp,
                    color = AppColors.white,
                    fontFamily = AppFonts.gmarketSans
                )
            }
            Spacer(modifier = Modifier.height(197.dp))


        }
        Image(
            painter = painterResource(R.drawable.under_background),
            contentDescription = "배경",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen() {

    }

}