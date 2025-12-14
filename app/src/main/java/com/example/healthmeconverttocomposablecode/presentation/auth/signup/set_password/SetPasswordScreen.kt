package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.presentation.component.MediumButton
import com.example.healthmeconverttocomposablecode.presentation.component.PasswordInputField
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun SetPasswordScreen(
    state: SetPasswordState,
    onPasswordChanged: (String) -> Unit,
    onPasswordConfirmChanged: (String) -> Unit
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = AppColors.mainColor)
                .padding(horizontal = 25.dp)
        ) {
            Spacer(modifier = Modifier.height(142.dp))
            Text(
                text = "Setting\na password",
                modifier = Modifier.padding(start = 13.dp),
                fontFamily = AppFonts.gmarketSans,
                color = AppColors.white,
                fontSize = 32.sp,
                lineHeight = 42.sp
            )
            Spacer(modifier = Modifier.height(21.dp))
            PasswordInputField(
                "비밀번호",
                { onPasswordChanged(it) },
                isSatisfyPasswordRule = state.isPasswordSatisfyRule
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                "· 10자리 이상의 영문, 특수문자(!#$%*@^&~?)만 사용 가능합니다.",
                fontSize = 8.sp,
                fontFamily = AppFonts.gmarketSans,
                lineHeight = 22.sp,
                color = AppColors.white,
                modifier = Modifier
                    .padding(start = 14.dp)
                    .alpha(if (state.isPasswordSatisfyRule == PasswordState.UNSATISFY) 1f else 0f)
            )
            Spacer(modifier = Modifier.height(3.dp))
            PasswordInputField(
                "비밀번호 확인",
                { onPasswordConfirmChanged(it) },
                state.isPasswordConfirmSatisfyRule
            )
            Spacer(modifier = Modifier.height(95.dp))
            Box(modifier = Modifier.padding(horizontal = 48.dp)) {
                MediumButton(isEnableButton = state.isNextButtonEnabled, text = "다음") {
                }
            }
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
fun SetPasswordScreenPreview() {
    //SetPasswordScreen("devmisterjerry@gmail.com")
}