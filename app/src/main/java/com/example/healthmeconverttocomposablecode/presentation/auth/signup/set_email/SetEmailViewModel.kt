package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_email

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SetEmailViewModel : ViewModel() {
    private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private val AUTH_CODE_REGEX = Regex("^\\d{6}$")

    private var _state = MutableStateFlow(SetEmailState())
    val state = _state.asStateFlow()

    fun isValidEmailType(email: String) {
        //Log.d("SetEmailViewModel", "전달된 이메일 값: '$email'") // 전달된 email이 무엇인지 확인
        if (EMAIL_REGEX.matches(email)) {
            _state.value = _state.value.copy(email = email, isRequestAuthCodeButtonEnabled = true)
        } else {
            _state.value = _state.value.copy(email = email, isRequestAuthCodeButtonEnabled = false)

        }
    }

    fun requestAuthCode() {
        _state.value = _state.value.copy(
            isCodeFieldVisible = true,
            isTextFieldEnabled = false,
            isRequestAuthCodeButtonEnabled = false,
            isAuthCodeFieldEnabled = true,
            isResendAuthCodeButtonEnabled = true
        )
    }

    fun isValidAuthCode(authCode: String) {
        if (AUTH_CODE_REGEX.matches(authCode)) {
            _state.value =
                _state.value.copy(isCheckAuthCodeButtonEnabled = true, authCode = authCode)
        } else {
            _state.value =
                _state.value.copy(isCheckAuthCodeButtonEnabled = false, authCode = authCode)

        }

    }

    fun checkAuthCode() {
        //TODO 체크 되었는지 하는 로직 추가할 것
        _state.value = _state.value.copy(
            isNextButtonEnabled = true,
            isCheckAuthCodeButtonEnabled = false,
            isResendAuthCodeButtonEnabled = false,
            isAuthCodeFieldEnabled = false
        )
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SetEmailViewModel()
            }
        }
    }

}