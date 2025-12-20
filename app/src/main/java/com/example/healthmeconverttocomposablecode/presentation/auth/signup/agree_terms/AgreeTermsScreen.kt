package com.example.healthmeconverttocomposablecode.presentation.auth.signup.agree_terms

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.example.healthmeconverttocomposablecode.presentation.component.AgreeTermsDialog
import com.example.healthmeconverttocomposablecode.presentation.component.MediumButton
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun AgreeTermsScreen(
    state: AgreeTermsState,
    onClickAgreeTermsButton: () -> Unit,
    onClickAllAgreeTermsButton: (Boolean,List<Boolean>) -> Unit,
    onClickNextButton:()->Unit,
) {
    Box {
        Column(
            modifier = Modifier
                .background(color = AppColors.mainColor)
                .padding(horizontal = 25.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(202.dp))
            Text(
                "Terms of\nservice",
                modifier = Modifier.padding(start = 13.dp),
                fontFamily = AppFonts.gmarketSans,
                fontSize = 31.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 37.5.sp,
                color = AppColors.white,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "회원가입 마지막 단계예요!\n헬스미 이용을 위해 이용약관을 확인해 주세요!",
                fontFamily = AppFonts.gmarketSans,
                color = AppColors.white,
                lineHeight = 17.sp,
                fontSize = 10.sp,
                modifier = Modifier.padding(start = 13.dp)
            )
            Spacer(modifier = Modifier.height(21.dp))
            //이용약관 동의하기 버튼
            Box(
                modifier = Modifier
                    .height(58.dp)
                    .fillMaxWidth()
                    .background(
                        color = AppColors.agreeTermsButtonColor,
                        shape = RoundedCornerShape(34.dp)
                    )
                    .clickable(
                        //enabled = !(state.isAllTermsAgreed),
                        onClick = { onClickAgreeTermsButton() }),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "이용약관 동의하기",
                    fontFamily = AppFonts.gmarketSans,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.agreeTermsButtonTextColor,
                    fontSize = 17.sp,
                    lineHeight = 22.sp
                )
                Icon(
                    painter = painterResource(R.drawable.password_no_check),
                    contentDescription = "체크버튼",
                    modifier = Modifier
                        .padding(end = 22.dp)
                        .align(Alignment.CenterEnd),
                    tint = if (state.isAllTermsAgreed) AppColors.agreeAllTermsCheckIconColor else AppColors.notAgreeAllTermsCheckIconBorderColor

                )
            }

            Spacer(modifier = Modifier.height(84.dp))

            Box(modifier = Modifier.padding(horizontal = 48.dp)) {
                MediumButton(text = "다음", onClick = {onClickNextButton()}, isEnableButton = state.isNextButtonEnabled)
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

    if (state.isDialogShow) {
        AgreeTermsDialog(isAgreeTerms = state.isAgreeTerms, onDismissRequest = { bool, booleans ->
            onClickAllAgreeTermsButton(bool,booleans)

        })
    }


}

@Preview(showBackground = true)
@Composable
private fun AgreeTermsScreenPreview() {
    //AgreeTermsScreen(AgreeTermsState(isDialogShow = false), {}, {})
}