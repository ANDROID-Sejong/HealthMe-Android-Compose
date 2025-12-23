package com.example.healthmeconverttocomposablecode.presentation.main.my_page

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.presentation.component.MyPageButton
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts


@Composable
fun MyPageScreen(modifier: Modifier = Modifier, onSelectedClick: () -> Unit) {
    Box {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .width(504.dp)
                .height(490.dp)
                .offset(y = (-150).dp)
        ) {
            val width = size.width
            val height = size.height

            val path = Path().apply {
                moveTo(0f, 0f)

                // 원의 반지름 느낌을 내기 위해 sideHeight를 조절
                // 하단 곡선 시작점 (전체 높이의 약 80~90%)
                val sideHeight = height * 0.85f
                lineTo(0f, sideHeight)

                // quadraticTo를 이용해 거대한 원형 곡선 구현
                // 제어점을 height보다 아래로 더 내려서 아주 완만한 곡선을 만듭니다.
                quadraticTo(
                    width / 2, height + 200f,
                    width, sideHeight
                )

                lineTo(width, 0f)
                close()
            }

            drawPath(
                path = path,
                brush = AppColors.myPageCanvasGradient
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {
            Text(
                "My Page",
                color = AppColors.myPageIndicatorColor,
                fontSize = 20.sp,
                fontFamily = AppFonts.gmarketSans,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(36.dp))


            Image(
                painter = painterResource(R.drawable.tmp_mypage_profile),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(114.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.CenterHorizontally),
                contentDescription = "프로필 사진",
            )

            Spacer(modifier = Modifier.height(19.dp))
            Text(
                "Hong Gilding",
                color = AppColors.white,
                fontSize = 20.sp,
                fontFamily = AppFonts.gmarketSans,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(19.dp))
            Box(
                modifier = Modifier
                    .height(72.dp)
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth()
                    .background(color = AppColors.white, shape = RoundedCornerShape(37.dp))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "키",
                            modifier = Modifier,
                            fontFamily = AppFonts.gmarketSans,
                            fontSize = 10.sp,
                            color = AppColors.myPageInfoCategoryTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "180",
                                modifier = Modifier,
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 20.sp,
                                color = AppColors.myPageInfoValueTextColor
                            )
                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                "cm",
                                modifier = Modifier,
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 10.sp,
                                color = AppColors.myPageInfoValueUnitTextColor
                            )

                        }
                    }
//                    VerticalDivider(modifier = Modifier
//                        .padding(vertical = 9.dp)
//                        .fillMaxHeight())

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "몸무게",
                            modifier = Modifier,
                            fontFamily = AppFonts.gmarketSans,
                            fontSize = 10.sp,
                            color = AppColors.myPageInfoCategoryTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "64",
                                modifier = Modifier,
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 20.sp,
                                color = AppColors.myPageInfoValueTextColor
                            )
                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                "kg",
                                modifier = Modifier,
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 10.sp,
                                color = AppColors.myPageInfoValueUnitTextColor
                            )

                        }
                    }
//                    VerticalDivider(modifier = Modifier
//                        .padding(vertical = 9.dp)
//                        .fillMaxHeight())

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "BMI",
                            modifier = Modifier,
                            fontFamily = AppFonts.gmarketSans,
                            fontSize = 10.sp,
                            color = AppColors.myPageInfoCategoryTextColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "19.75",
                                modifier = Modifier,
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 20.sp,
                                color = AppColors.myPageInfoBmiNormalTextColor
                            )
                        }
                    }
                }


            }
            Spacer(modifier = Modifier.height(22.dp))
            HorizontalDivider(thickness = 5.dp, color = AppColors.myPageHorizontalDividerColor)
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(horizontal = 32.dp)) {
                MyPageButton(
                    onClick = {},
                    text = "신체정보",
                    iconId = R.drawable.mypage_bodyinfo_icon
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier.padding(horizontal = 32.dp)) {
                MyPageButton(
                    onClick = {},
                    text = "환경설정",
                    iconId = R.drawable.mypage_setting_icon
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier.padding(horizontal = 32.dp)) {
                MyPageButton(
                    onClick = {},
                    text = "공지사항",
                    iconId = R.drawable.mypage_notice_icon
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier.padding(horizontal = 32.dp)) {
                MyPageButton(
                    onClick = {},
                    text = "앱 버전",
                    iconId = R.drawable.mypage_app_version_icon
                )
            }

        }
    }

}

@Preview(showBackground = true,
    showSystemUi = true
)
@Composable
private fun MyPageScreenPreview() {
    MyPageScreen() {}
}