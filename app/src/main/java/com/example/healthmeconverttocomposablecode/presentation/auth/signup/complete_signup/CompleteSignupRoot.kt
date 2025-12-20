package com.example.healthmeconverttocomposablecode.presentation.auth.signup.complete_signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CompleteSignupRoot(onClickScreen:()-> Unit) {
    CompleteSignupScreen(onClickScreen = {onClickScreen()})
}

@Preview(showBackground = true)
@Composable
private fun CompleteSignupRootPreview() {
    CompleteSignupRoot({})

}