package com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_information

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SetInformationRoot(
    email: String,
    password: String,
    viewModel: SetInformationViewModel = viewModel(factory = SetInformationViewModel.Factory)
) {
    val state by viewModel.state.collectAsState()
    SetInformationScreen(
        state = state,
        onChangeName = {
            viewModel.isValidName(it)
        },
        onChangeBirthDate = {
            viewModel.isValidBirthDate(it)
        },
        onChangeHeight = {
            viewModel.isValidHeight(it)
        },
        onChangeWeight = {
            viewModel.isValidWeight(it)
        },
        onButtonClick = {
            viewModel.clickGenderButton(it)
        }


    )


}