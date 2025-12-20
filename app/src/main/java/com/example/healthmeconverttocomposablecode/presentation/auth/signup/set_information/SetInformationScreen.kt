package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_information

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.healthmeconverttocomposablecode.presentation.component.InformationInputField
import com.example.healthmeconverttocomposablecode.presentation.component.MediumButton
import com.example.healthmeconverttocomposablecode.presentation.component.SmallButton
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun SetInformationScreen(
    state: SetInformationState,
    onChangeName: (String) -> Unit,
    onChangeBirthDate: (String) -> Unit,
    onChangeHeight: (String) -> Unit,
    onChangeWeight: (String) -> Unit,
    onButtonClick: (String) -> Unit,
    onNextButtonClick: (
        name: String,
        birthDate: String,
        gender: GenderState,
        height: String,
        weight: String
    ) -> Unit
) {
    Box {
        Column(
            modifier = Modifier
                .background(color = AppColors.mainColor)
                .padding(horizontal = 31.dp)
                .fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(110.dp))
            Text(
                "Enter\nYour\nInformation",
                fontFamily = AppFonts.gmarketSans,
                fontSize = 31.sp,
                color = AppColors.white,
                lineHeight = 37.5.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(24.dp))

            InformationInputField(
                "이름",
                onValueChanged = { onChangeName(it) },
                isSatisfyRule = state.isNameSatisfyRule
            )
            Spacer(modifier = Modifier.height(11.dp))

            InformationInputField(
                "생년월일",
                onValueChanged = { onChangeBirthDate(it) },
                isSatisfyRule = state.isBirthDateSatisfyRule
            )
            Spacer(modifier = Modifier.height(11.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "성별 *",
                    modifier = Modifier.padding(start = 7.dp),
                    color = AppColors.white,
                    fontSize = 16.sp,
                    fontFamily = AppFonts.gmarketSans
                )
                Spacer(modifier = Modifier.height(6.dp))

                Row(modifier = Modifier) {
                    SmallButton(
                        text = "남성", onClick = {
                            onButtonClick("남성")
                        },
                        isEnableButton = state.gender == GenderState.MALE
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    SmallButton(text = "여성", onClick = {
                        onButtonClick("여성")
                    }, isEnableButton = state.gender == GenderState.FEMALE)

                }

            }
            Spacer(modifier = Modifier.height(11.dp))

            InformationInputField(
                "신장",
                onValueChanged = { onChangeHeight(it) },
                placeholder = "cm",
                isSatisfyRule = state.isHeightSatisfyRule
            )
            Spacer(modifier = Modifier.height(11.dp))

            InformationInputField(
                "몸무게",
                onValueChanged = { onChangeWeight(it) },
                placeholder = "kg",
                isSatisfyRule = state.isWeightSatisfyRule
            )
            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier.padding(horizontal = 42.dp)) {
                MediumButton(isEnableButton = state.isNextButtonEnabled, text = "다음", onClick = {
                    onNextButtonClick(
                        state.name,
                        state.birthDate,
                        state.gender,
                        state.height,
                        state.weight
                    )
                })
            }
            Spacer(modifier = Modifier.height(136.dp))
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
private fun SetInformationScreenPreview() {
    SetInformationScreen(
        SetInformationState(isNextButtonEnabled = true), {}, {}, {}, {}, {},
        onNextButtonClick = {_,_,_,_,_  -> }
    )
}