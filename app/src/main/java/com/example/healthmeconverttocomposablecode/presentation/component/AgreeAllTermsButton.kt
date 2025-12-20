package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.ui.AppFonts
import com.example.healthmeconverttocomposablecode.ui.AppColors

@Composable
fun AgreeAllTermsButton(
    text: String,
    backgroundColor: Color = AppColors.agreeAllTermsButtonColor,
    isAllTermsChecked: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
            .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick), contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = AppFonts.gmarketSans,
            fontWeight = FontWeight.Bold,
            color = AppColors.white,
            fontSize = 15.sp
        )
        Box(
            modifier = Modifier
                .padding(start = 26.dp)
                .size(15.dp)
                .align(Alignment.CenterStart)
                .background(
                    color = AppColors.white, shape = RoundedCornerShape(2.dp)
                )
            , contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.password_wrong_check),
                contentDescription = "전체동의",
                tint = if(isAllTermsChecked)AppColors.red else Color.Transparent,
                modifier = Modifier.size(8.33.dp, 5.83.dp).fillMaxSize()
            )
        }

    }

}

@Preview(showBackground = false)
@Composable
fun AgreeAllTermsButtonPreview() {
    AgreeAllTermsButton("전체동의", onClick = {}, isAllTermsChecked = true)
}