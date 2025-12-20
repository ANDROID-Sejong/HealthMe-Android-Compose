package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun AgreeTermsDialog(
    isAgreeTerms: List<Boolean>,
    onDismissRequest: (Boolean, List<Boolean>) -> Unit
) {
    val agreeTerms = remember {
        mutableStateListOf<Boolean>().apply {
            isAgreeTerms.forEach {
                add(it)
            }
        }
    }
    val isAgreeAllTerms = remember {
        derivedStateOf {
            agreeTerms.all { it }
        }
    }

    Dialog(onDismissRequest = { onDismissRequest(false, agreeTerms) }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = AppColors.white, shape = RoundedCornerShape(26.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.padding(horizontal = 26.dp)) {
                Spacer(modifier = Modifier.height(42.dp))
                Text(
                    modifier = Modifier,
                    text = "Terms of service",
                    fontFamily = AppFonts.gmarketSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 22.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "Healthme를 시작 및 가입을 위해 \n아래의 약관들을 확인해주세요.",
                    fontFamily = AppFonts.gmarketSans,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 10.sp,
                    lineHeight = 15.sp,
                    color = AppColors.agreeTermsSmallTextColor
                )
                Spacer(modifier = Modifier.height(21.dp))
                AgreeAllTermsButton(text = "전체동의", onClick = {
                    if (isAgreeAllTerms.value) {
                        agreeTerms.forEachIndexed { index, _ ->
                            agreeTerms[index] = false
                        }
                    } else {
                        agreeTerms.forEachIndexed { index, _ ->
                            agreeTerms[index] = true
                        }
                    }

                }, isAllTermsChecked = isAgreeAllTerms.value
                )
                Spacer(modifier = Modifier.height(22.dp))
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    thickness = 1.dp,
                    color = AppColors.horizontalDividerColor
                )
                Spacer(modifier = Modifier.height(29.dp))
                Box(modifier = Modifier.padding(horizontal = 25.dp)) {
                    AgreeTermItem(isAgree = agreeTerms[0], onClick = {
                        agreeTerms[0] = !agreeTerms[0]
                    })
                }
                Spacer(modifier = Modifier.height(18.dp))
                Box(modifier = Modifier.padding(horizontal = 25.dp)) {
                    AgreeTermItem(isAgree = agreeTerms[1], onClick = {
                        agreeTerms[1] = !agreeTerms[1]
                    })
                }
                Spacer(modifier = Modifier.height(18.dp))

                Box(modifier = Modifier.padding(horizontal = 25.dp)) {
                    AgreeTermItem(isAgree = agreeTerms[2], onClick = {
                        agreeTerms[2] = !agreeTerms[2]
                    })
                }
                Spacer(modifier = Modifier.height(18.dp))
                Box(modifier = Modifier.padding(horizontal = 25.dp)) {
                    AgreeTermItem(isAgree = agreeTerms[3], onClick = {
                        agreeTerms[3] = !agreeTerms[3]
                    })
                }
                Spacer(modifier = Modifier.height(238.dp))
            }



            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 37.dp)
            ) {
                AgreeTermsButton(
                    isEnableButton = isAgreeAllTerms.value,
                    onClick = { onDismissRequest(true, agreeTerms) })
                Spacer(modifier = Modifier.height(31.dp))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AgreeTermsDialogPreview() {
    //AgreeTermsDialog(onDismissRequest = {})

}