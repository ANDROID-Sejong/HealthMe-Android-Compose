package com.example.healthmeconverttocomposablecode.presentation.auth.signup.agree_terms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AgreeTermsViewModel(

): ViewModel() {

    private var _state = MutableStateFlow(AgreeTermsState())
    val state = _state.asStateFlow()

    fun toggleDialog(){
        _state.value = _state.value.copy(isDialogShow = !(_state.value.isDialogShow))
    }
    fun enableNextButton(){
        _state.value = _state.value.copy(isNextButtonEnabled = true, isAllTermsAgreed = true)
    }
    fun disableNextButton(){
        _state.value = _state.value.copy(isNextButtonEnabled = false, isAllTermsAgreed = false)
    }
    fun agreeTerm(result : List<Boolean>){
        _state.value = _state.value.copy(isAgreeTerms = result)

    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AgreeTermsViewModel()
            }
        }
    }
}