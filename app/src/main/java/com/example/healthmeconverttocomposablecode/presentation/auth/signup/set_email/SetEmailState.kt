package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_email

data class SetEmailState(
    val email: String = "",
    val isCodeFieldVisible: Boolean = false,
    val authCode: String = "",
    val isResendAuthCodeButtonEnabled: Boolean = false,
    val isNextButtonEnabled: Boolean = false,
    val isRequestAuthCodeButtonEnabled: Boolean = false,
    val remainingTime: Int = 300,
    val isTextFieldEnabled: Boolean = true,
    val isAuthCodeFieldEnabled: Boolean = false,
    val isCheckAuthCodeButtonEnabled: Boolean = false
)