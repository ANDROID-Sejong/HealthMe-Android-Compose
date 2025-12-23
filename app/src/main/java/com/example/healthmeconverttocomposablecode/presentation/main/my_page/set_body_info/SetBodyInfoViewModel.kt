package com.example.healthmeconverttocomposablecode.presentation.main.my_page.set_body_info

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SetBodyInfoViewModel: ViewModel(){

    private val _state = MutableStateFlow(SetBodyInfoState())
    val state = _state.asStateFlow()
    fun changeMode(){
        _state.value = _state.value.copy(isEditMode = (!_state.value.isEditMode))
    }
}