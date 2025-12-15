package com.example.healthmeconverttocomposablecode.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts
import com.example.healthmeconverttocomposablecode.R


@Composable
fun InformationInputField(
    label: String,
    placeholder: String = "",
    onValueChanged: (String) -> Unit,
    isSatisfyRule: Boolean = false
) {

    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            "$label *",
            fontFamily = AppFonts.gmarketSans,
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            color = AppColors.white,
            modifier = Modifier.padding(start = 7.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .height(31.dp)
                .background(color = AppColors.white, shape = RoundedCornerShape(34.dp))
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = AppColors.white,
                        shape = RoundedCornerShape(34.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically

            ) {
                BasicTextField(
                    value = inputText,
                    onValueChange = {
                        onValueChanged(it)
                        inputText = it
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 23.dp)
                    ,
                    textStyle = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = AppFonts.gmarketSans,
                        color = AppColors.black,
                        lineHeight = 22.sp
                    ),
                    singleLine = true
                )
                Text(
                    text = placeholder,
                    modifier = Modifier,
                    color = AppColors.informationInputFieldUnitTextColor,
                    fontSize = 13.sp,
                    fontFamily = AppFonts.gmarketSans,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 22.sp
                )

                Image(
                    painter = if (isSatisfyRule) painterResource(R.drawable.password_check) else painterResource(
                        R.drawable.password_no_check
                    ),
                    contentDescription = "체크표시",
                    modifier = Modifier
                        .padding(start = 15.dp, end = 20.dp)
                        .fillMaxHeight()
                )
            }


        }

    }


}

@Preview(showBackground = true)
@Composable
private fun InformationInputFieldPreview() {
    InformationInputField(label = "이름", onValueChanged = { (it) }, placeholder = "cm")

}