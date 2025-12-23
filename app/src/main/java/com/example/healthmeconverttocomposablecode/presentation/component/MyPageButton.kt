package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun MyPageButton(
    text: String,
    @DrawableRes iconId: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(25.dp))
            .background(color = AppColors.white)
            .clickable(onClick = { onClick() }),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(modifier = Modifier) {
            Spacer(modifier = Modifier.width(25.dp))
            Icon(
                painter = painterResource(iconId),
                contentDescription = "${text}메뉴 아이콘",
                tint = AppColors.mainColor,
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontFamily = AppFonts.gmarketSans,
                fontSize = 22.sp,
                color = AppColors.black,
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun MyPageButtonPreview() {
    //MyPageButton(onClick = {})
}