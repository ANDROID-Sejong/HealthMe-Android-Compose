package com.example.healthmeconverttocomposablecode.presentation.auth.signup.complete_signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun CompleteSignupScreen(onClickScreen: () -> Unit) {

    Box(modifier = Modifier.clickable(onClick = { onClickScreen() })) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = AppColors.mainColor)
                .padding(horizontal = 86.dp)
        ) {

            Spacer(modifier = Modifier.height(162.dp))
            Text(
                "welcome\nto\nHealth Me!",
                fontFamily = AppFonts.gmarketSans,
                textAlign = TextAlign.Center,
                color = AppColors.white,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 42.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(79.dp))
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.sign_up_greeting_logo),
                contentDescription = "로고"
            )
        }

        Image(
            painter = painterResource(R.drawable.under_background),
            contentDescription = "배경",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
        Text(
            modifier = Modifier
                .padding(bottom = 142.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            text = "Tap to start!",
            textAlign = TextAlign.Center,
            color = AppColors.greetingTextColor,
            fontSize = 16.sp,
            fontFamily = AppFonts.gmarketSans
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun CompleteSignupScreenPreview() {
    CompleteSignupScreen({})

}