package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_email

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.presentation.component.AuthCodeInputField
import com.example.healthmeconverttocomposablecode.presentation.component.EmailAuthInputField
import com.example.healthmeconverttocomposablecode.presentation.component.MediumButton
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun SetEmailScreen(
    onNextButtonClick: (String) -> Unit,
    setEmailState: SetEmailState,
    onEmailFieldChange: (String) -> Unit,
    onAutoCodeRequestButtonClick: () -> Unit,
    onAuthCodeFieldChange: (String) -> Unit,
    onAuthCodeCheckButtonClick: () -> Unit
) {
    val state = setEmailState

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = AppColors.mainColor)
                .padding(horizontal = 25.dp), verticalArrangement = Arrangement.Center

        ) {
            Spacer(modifier = Modifier.height(142.dp))
            Text(
                "Enter\nyour Email",
                modifier = Modifier.padding(start = 13.dp),
                color = AppColors.white,
                fontSize = 32.sp,
                fontFamily = AppFonts.gmarketSans,
                lineHeight = 42.sp
            )
            Spacer(modifier = Modifier.height(21.dp))
            EmailAuthInputField(
                label = "이메일",
                value = state.email,
                placeholder = "health@gmail.com",
                onClick = { onAutoCodeRequestButtonClick() },
                onValueChange = ({ onEmailFieldChange(it) }),
                isEnableButton = state.isRequestAuthCodeButtonEnabled,
                isTextFieldEnable = state.isTextFieldEnabled
            )
            Spacer(modifier = Modifier.height(13.dp))
            if (state.isCodeFieldVisible) {
                AuthCodeInputField(
                    "인증코드",
                    onResendClick = {},
                    value = state.authCode,
                    onVerifyClick = { onAuthCodeCheckButtonClick() },
                    onValueChange = { onAuthCodeFieldChange(it) },
                    remainingTime = "",//TODO 타이머 구현 후 수정,
                    isEnableCheckButtonClick = state.isCheckAuthCodeButtonEnabled,
                    isTextFieldEnable = state.isAuthCodeFieldEnabled,
                    isResendButtonEnable = state.isResendAuthCodeButtonEnabled
                )
            } else {
                Spacer(modifier = Modifier.height(82.dp))
            }

            Spacer(modifier = Modifier.height(102.dp))
            Box(modifier = Modifier.padding(horizontal = 48.dp)) {
                MediumButton("다음", isEnableButton = state.isNextButtonEnabled, onClick = {
                    onNextButtonClick(state.email)
                })
            }
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
fun SetEmailScreenPreview() {
    //SetEmailScreen({})
}