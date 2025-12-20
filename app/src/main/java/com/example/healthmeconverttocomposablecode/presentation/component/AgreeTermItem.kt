package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun AgreeTermItem(isAgree: Boolean,onClick:()-> Unit) {
    Row(
        modifier = Modifier
            .height(22.dp)
            .fillMaxWidth()
            .clickable(onClick = { onClick() })
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(15.dp)
                .border(width = 1.dp, color = AppColors.black)
                .padding(horizontal = 3.33.dp),
            contentAlignment = Alignment.Center
        )
        {
            Icon(
                painter = painterResource(R.drawable.password_wrong_check),
                contentDescription = "체크박스"
                ,tint = if(isAgree) AppColors.red else Color.Transparent
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "(필수) 이용약관 동의",
            modifier = Modifier.weight(1f),
            fontFamily = AppFonts.gmarketSans,
            fontSize = 10.sp,
            lineHeight = 22.sp
        )
        Icon(
            painter = painterResource(R.drawable.indicate_detail_term),
            contentDescription = "세부사항 보기",
            tint = AppColors.horizontalDividerColor
        )


    }

}

@Preview(showBackground = true)
@Composable
private fun AgreeTermItemPreview() {
    AgreeTermItem(false,{})

}