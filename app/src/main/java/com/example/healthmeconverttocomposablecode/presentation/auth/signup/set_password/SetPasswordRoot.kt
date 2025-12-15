package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SetPasswordRoot(
    email: String,
    viewModel: SetPasswordViewModel = viewModel(factory = SetPasswordViewModel.Factory),
    onNextButtonClick: (String, String) -> Unit
) {
    val state by viewModel.state.collectAsState()
    SetPasswordScreen(
        state = state,
        onPasswordChanged = {
            viewModel.isSatisfyRule(it, isConfirmPassword = false)
        },
        onPasswordConfirmChanged = {
            viewModel.isSatisfyRule(it, isConfirmPassword = true)
        },
        onNextButtonClick = {
            onNextButtonClick(email,viewModel.state.value.password)
        }
    )
}