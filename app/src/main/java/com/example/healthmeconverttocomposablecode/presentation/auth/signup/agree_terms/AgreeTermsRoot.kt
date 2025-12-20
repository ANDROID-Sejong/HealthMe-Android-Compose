package com.example.healthmeconverttocomposablecode.presentation.auth.signup.agree_terms

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AgreeTermsRoot(viewModel: AgreeTermsViewModel= viewModel(factory = AgreeTermsViewModel.Factory)) {

    val state = viewModel.state.collectAsState()

    AgreeTermsScreen(
        state = state.value,
        onClickAgreeTermsButton = {
        viewModel.toggleDialog()
    },
        onClickAllAgreeTermsButton = {bool, booleans ->
            if(bool){
                viewModel.toggleDialog()
                viewModel.enableNextButton()
                viewModel.agreeTerm(booleans)
            }
            else{
                viewModel.toggleDialog()
                viewModel.disableNextButton()
                viewModel.agreeTerm(booleans)
            }

        }

    )
    
}

@Preview(showBackground = true)
@Composable
private fun AgreeTermsRootPreview() {
    AgreeTermsRoot()
    
}