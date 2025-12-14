package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_email

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SetEmailRoot(viewmodel: SetEmailViewModel = viewModel(factory = SetEmailViewModel.Factory),onNextButtonClick:(String)-> Unit) {

    val setEmailState by viewmodel.state.collectAsState()

    SetEmailScreen(
        onNextButtonClick = {onNextButtonClick(it)},
        setEmailState = setEmailState,
        onEmailFieldChange = {
            viewmodel.isValidEmailType(it)
        },
        onAutoCodeRequestButtonClick = {
            viewmodel.requestAuthCode()
        },
        onAuthCodeFieldChange = {
            viewmodel.isValidAuthCode(it)
        },
        onAuthCodeCheckButtonClick = {
            viewmodel.checkAuthCode()
        },

        )


}