package com.example.healthmeconverttocomposablecode.presentation.auth.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.presentation.component.BigButton
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun SplashScreen(onLoginButtonClick: () -> Unit, onSignUpButtonClick: () -> Unit) {

    Box(modifier = Modifier.background(AppColors.mainColor)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 44.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(157.dp))
            Text(
                "Let's\nexercise\ntogether",
                fontFamily = AppFonts.gmarketSans,
                fontWeight = FontWeight.Bold,
                fontSize = 47.sp,
                textAlign = TextAlign.Center,
                lineHeight = 56.sp,
                style = TextStyle(AppColors.firstScreenTextBrush)
            )
            Spacer(modifier = Modifier.height(74.dp))
            BigButton("로그인") {
                onLoginButtonClick()
            }
            Spacer(modifier = Modifier.height(18.dp))
            BigButton("회원가입", backgroundColor = AppColors.white, textColor = AppColors.black) {
                onSignUpButtonClick()
            }
            //TODO 나중에 색상 변경할 것
            Spacer(modifier = Modifier.height(224.dp))
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
fun SplashScreenPreview(modifier: Modifier = Modifier) {
    SplashScreen({}, {})
}