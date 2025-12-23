package com.example.healthmeconverttocomposablecode.presentation.main.my_page.set_body_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun SetBodyInfoScreen(
    state: SetBodyInfoState,
    onClickSaveButton: () -> Unit,
    onClickChangeModeButton: () -> Unit,
    onClickBackButton: () -> Unit,

    onBirthDateValueChange: (String) -> Unit
) {


    Box(modifier = Modifier.fillMaxSize()) {
        Text("", modifier = Modifier.fillMaxSize())
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = AppColors.myPageSetBodyInfoGradient),
        ) {
            Spacer(modifier = Modifier.height(58.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_back_button),
                    contentDescription = "뒤로가기버튼",
                    tint = AppColors.white,
                    modifier = Modifier
                        .width(24.dp)
                        .clickable(onClick = { onClickBackButton() })
                )
                Text(
                    "신체정보",
                    fontFamily = AppFonts.gmarketSans,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.white,
                )
                Box(
                    modifier = Modifier.size(24.dp)
                ) {
                    if (state.isEditMode) {
                        Text(
                            "저장",
                            modifier = Modifier
                                .clickable(
                                    onClick = { onClickSaveButton() }
                                )
                                .wrapContentWidth(unbounded = true) //

                        )
                    } else {
                        Icon(
                            modifier = Modifier
                                .clickable(
                                    onClick = { onClickChangeModeButton() }),
                            painter = painterResource(R.drawable.icon_edit_button),
                            contentDescription = "수정버튼",
                            tint = AppColors.white,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(49.dp))

            Image(
                modifier = Modifier
                    .size(124.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.tmp_mypage_profile),
                contentDescription = "프사",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(49.dp))
            Text(
                "Gildong",
                fontFamily = AppFonts.gmarketSans,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = AppColors.white,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(29.dp))
            Text(
                "생년월일",
                fontFamily = AppFonts.gmarketSans,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = AppColors.myPageSetBodyCategoryTextColor,
                modifier = Modifier.padding(start = 32.dp)
            )
            Spacer(modifier = Modifier.height(9.dp))
            BasicTextField(
                enabled = state.isEditMode,
                value = state.birthDate,
                onValueChange = { onBirthDateValueChange(it) },
                textStyle = TextStyle(
                    fontFamily = AppFonts.gmarketSans,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (state.isEditMode) AppColors.myPageSetBodyInfoEditModeTextColor else AppColors.white,
                ),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 32.dp),
                color = AppColors.myPageSetBodyCategoryDividerColor
            )
            //
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "성별",
                fontFamily = AppFonts.gmarketSans,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = AppColors.myPageSetBodyCategoryTextColor,
                modifier = Modifier.padding(start = 32.dp)
            )
            Spacer(modifier = Modifier.height(9.dp))
            BasicTextField(
                enabled = state.isEditMode,
                value = state.gender,
                onValueChange = {  },
                textStyle = TextStyle(
                    fontFamily = AppFonts.gmarketSans,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (state.isEditMode) AppColors.myPageSetBodyInfoEditModeTextColor else AppColors.white,
                ),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 32.dp),
                color = AppColors.myPageSetBodyCategoryDividerColor
            )
//
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "신장",
                fontFamily = AppFonts.gmarketSans,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = AppColors.myPageSetBodyCategoryTextColor,
                modifier = Modifier.padding(start = 32.dp)
            )
            Spacer(modifier = Modifier.height(9.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BasicTextField(
                    enabled = state.isEditMode,
                    value = state.height,
                    onValueChange = {  },
                    textStyle = TextStyle(
                        fontFamily = AppFonts.gmarketSans,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (state.isEditMode) AppColors.myPageSetBodyInfoEditModeTextColor else AppColors.white,
                    ),
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = "cm",
                    fontFamily = AppFonts.gmarketSans,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColors.myPageSetBodyCategoryTextColor,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 27.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 32.dp),
                color = AppColors.myPageSetBodyCategoryTextColor
            )
            //
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "몸무게",
                fontFamily = AppFonts.gmarketSans,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = AppColors.myPageSetBodyCategoryTextColor,
                modifier = Modifier.padding(start = 32.dp)
            )
            Spacer(modifier = Modifier.height(9.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BasicTextField(
                    enabled = state.isEditMode,
                    value = state.weight,
                    onValueChange = {  },
                    textStyle = TextStyle(
                        fontFamily = AppFonts.gmarketSans,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (state.isEditMode) AppColors.myPageSetBodyInfoEditModeTextColor else AppColors.white,
                    ),
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = "kg",
                    fontFamily = AppFonts.gmarketSans,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = AppColors.myPageSetBodyCategoryTextColor,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 27.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 32.dp),
                color = AppColors.myPageSetBodyCategoryDividerColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SetBodyInfoScreenPreview() {
    //SetBodyInfoScreen()
}