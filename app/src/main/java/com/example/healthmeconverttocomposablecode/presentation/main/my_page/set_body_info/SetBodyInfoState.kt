package com.example.healthmeconverttocomposablecode.presentation.main.my_page.set_body_info

data class SetBodyInfoState(
    val isEditMode: Boolean = false,
    val birthDate:String = "2000.02.09",
    val gender :String = "남성", //TODO 나중에 GenderState로 바꿀 것
    val height: String = "180",
    val weight:String = "64"
)
