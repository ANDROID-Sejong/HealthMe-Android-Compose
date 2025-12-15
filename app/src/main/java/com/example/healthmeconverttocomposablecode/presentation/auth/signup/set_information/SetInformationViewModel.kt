package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


private val NAME_REGEX = Regex("^.{2,}\$")
private val BIRTHDATE_REGEX = Regex("^\\d{4}\\.(0[1-9]|1[0-2])\\.(0[1-9]|[12]\\d|3[01])$")
private val HEIGHT_REGEX = Regex("^(?:[1-9]|[1-9][0-9]|[1-2][0-9]{2}|300)$")
private val WEIGHT_REGEX = Regex("^(?:[1-9]|[1-9][0-9]|[1-6][0-9]{2}|700)$")

class SetInformationViewModel(

) : ViewModel() {


    private var _state = MutableStateFlow(SetInformationState())
    val state = _state.asStateFlow()

    fun isValidName(name: String) {
        if (NAME_REGEX.matches(name)) {

            _state.value = _state.value.copy(name = name, isNameSatisfyRule = true)
        } else {
            _state.value = _state.value.copy(name = name, isNameSatisfyRule = false)
        }
        if (isAllInformationValid(_state.value)) {
            _state.value = _state.value.copy(isNextButtonEnabled = true)
        } else {
            _state.value = _state.value.copy(isNextButtonEnabled = false)
        }
    }

    fun isValidBirthDate(birthDate: String) {
        if (BIRTHDATE_REGEX.matches(birthDate)) {
            _state.value = _state.value.copy(birthDate = birthDate, isBirthDateSatisfyRule = true)
        } else {
            _state.value = _state.value.copy(birthDate = birthDate, isBirthDateSatisfyRule = false)
        }
        if (isAllInformationValid(_state.value)) {
            _state.value = _state.value.copy(isNextButtonEnabled = true)
        } else {
            _state.value = _state.value.copy(isNextButtonEnabled = false)
        }
    }

    fun isValidHeight(height: String) {
        if (HEIGHT_REGEX.matches(height)) {
            _state.value = _state.value.copy(height = height, isHeightSatisfyRule = true)
        } else {
            _state.value = _state.value.copy(height = height, isHeightSatisfyRule = false)
        }
        if (isAllInformationValid(_state.value)) {
            _state.value = _state.value.copy(isNextButtonEnabled = true)
        } else {
            _state.value = _state.value.copy(isNextButtonEnabled = false)
        }
    }

    fun isValidWeight(weight: String) {
        if (WEIGHT_REGEX.matches(weight)) {
            _state.value = _state.value.copy(weight = weight, isWeightSatisfyRule = true)
        } else {
            _state.value = _state.value.copy(weight = weight, isWeightSatisfyRule = false)
        }
        if (isAllInformationValid(_state.value)) {
            _state.value = _state.value.copy(isNextButtonEnabled = true)
        } else {
            _state.value = _state.value.copy(isNextButtonEnabled = false)
        }
    }

    fun clickGenderButton(gender: String) {
        when (state.value.gender) {
            GenderState.NONE -> {
                when (gender) {
                    "남성" -> {
                        _state.value = _state.value.copy(gender = GenderState.MALE)
                    }

                    "여성" -> {
                        _state.value = _state.value.copy(gender = GenderState.FEMALE)
                    }
                }
            }

            GenderState.FEMALE -> {
                when (gender) {
                    "남성" -> {
                        _state.value = _state.value.copy(gender = GenderState.MALE)
                    }

                    "여성" -> {
                        _state.value = _state.value.copy(gender = GenderState.NONE)
                    }
                }

            }

            GenderState.MALE -> {
                when (gender) {
                    "남성" -> {
                        _state.value = _state.value.copy(gender = GenderState.NONE)
                    }

                    "여성" -> {
                        _state.value = _state.value.copy(gender = GenderState.FEMALE)
                    }
                }
            }
        }
        if (isAllInformationValid(_state.value)) {
            _state.value = _state.value.copy(isNextButtonEnabled = true)
        } else {
            _state.value = _state.value.copy(isNextButtonEnabled = false)
        }

    }

    fun isAllInformationValid(state: SetInformationState): Boolean {
        return NAME_REGEX.matches(state.name) && BIRTHDATE_REGEX.matches(state.birthDate) && state.gender != GenderState.NONE && HEIGHT_REGEX.matches(
            state.height
        ) && WEIGHT_REGEX.matches(state.weight)
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SetInformationViewModel()
            }
        }
    }
}