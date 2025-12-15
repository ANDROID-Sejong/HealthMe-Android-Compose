package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

private val PASSWORD_REGEX = Regex("^[a-zA-Z!#$%*@^&~?]{10,}$")
class SetPasswordViewModel() : ViewModel() {
    private var _state = MutableStateFlow(SetPasswordState())
    val state = _state.asStateFlow()
    fun isSatisfyRule(password: String, isConfirmPassword: Boolean) {
        when (isConfirmPassword) {
            true -> {
                if (state.value.password == password) {
                    if (state.value.isPasswordSatisfyRule == PasswordState.SATISFY) {
                        _state.value = _state.value.copy(
                            isNextButtonEnabled = true,
                            isPasswordConfirmSatisfyRule = PasswordState.SATISFY,
                            passwordConfirm = password
                        )
                    } else {
                        _state.value = _state.value.copy(
                            isPasswordConfirmSatisfyRule = PasswordState.SATISFY,
                            passwordConfirm = password,
                            isNextButtonEnabled = false
                        )
                    }
                } else {
                    if (password.isEmpty()) {

                        _state.value = _state.value.copy(
                            isPasswordConfirmSatisfyRule = PasswordState.NORMAL,
                            passwordConfirm = password,
                            isNextButtonEnabled = false

                        )
                    } else {
                        _state.value = _state.value.copy(
                            isPasswordConfirmSatisfyRule = PasswordState.UNSATISFY,
                            passwordConfirm = password,
                            isNextButtonEnabled = false

                        )
                    }
                }
            }

            false -> {
                if (PASSWORD_REGEX.matches(password)) {
                    _state.value = _state.value.copy(
                        isPasswordSatisfyRule = PasswordState.SATISFY,
                        password = password,
                        isNextButtonEnabled = false

                    )
                } else {
                    if (password.isEmpty()) {
                        _state.value = _state.value.copy(
                            isPasswordSatisfyRule = PasswordState.NORMAL,
                            password = password,
                            isNextButtonEnabled = false

                        )
                    } else {
                        _state.value = _state.value.copy(
                            isPasswordSatisfyRule = PasswordState.UNSATISFY,
                            password = password,
                            isNextButtonEnabled = false

                        )
                    }
                }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SetPasswordViewModel()
            }
        }
    }
}