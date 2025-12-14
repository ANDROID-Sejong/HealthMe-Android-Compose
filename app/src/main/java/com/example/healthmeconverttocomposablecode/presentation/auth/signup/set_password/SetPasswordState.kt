package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_password

data class SetPasswordState(
    val isPasswordSatisfyRule: PasswordState = PasswordState.NORMAL,
    val isPasswordConfirmSatisfyRule: PasswordState = PasswordState.NORMAL,
    val password: String = "",
    val passwordConfirm: String = "",
    val isNextButtonEnabled: Boolean = false,
    )

enum class PasswordState {
    NORMAL,
    SATISFY,
    UNSATISFY
}
