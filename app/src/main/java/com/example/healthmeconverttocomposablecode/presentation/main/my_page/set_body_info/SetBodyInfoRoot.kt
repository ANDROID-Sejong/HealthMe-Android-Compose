package com.example.healthmeconverttocomposablecode.presentation.main.my_page.set_body_info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SetBodyInfoRoot(
    viewModel: SetBodyInfoViewModel = koinViewModel(),
    onClickBackButton: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    SetBodyInfoScreen(
        state,
        onClickSaveButton = { viewModel.changeMode() },
        onClickChangeModeButton = { viewModel.changeMode() },
        onBirthDateValueChange = {},
        onClickBackButton = { onClickBackButton() }
    )

}

@Preview
@Composable
private fun SetBodyInfoRootPreview() {
    //SetBodyInfoScreen(SetBodyInfoState())
}