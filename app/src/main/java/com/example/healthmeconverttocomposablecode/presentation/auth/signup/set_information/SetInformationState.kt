package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_information

data class SetInformationState(
    val name: String = "",
    val birthDate: String = "",
    val gender: GenderState = GenderState.NONE,
    val height: String = "",
    val weight: String = "",
    val isNextButtonEnabled: Boolean = false,
    val isNameSatisfyRule: Boolean = false,
    val isBirthDateSatisfyRule: Boolean = false,
    val isHeightSatisfyRule: Boolean = false,
    val isWeightSatisfyRule: Boolean = false,
    )

enum class GenderState{
    MALE,
    FEMALE,
    NONE
}