package com.example.healthmeconverttocomposablecode.presentation.auth.signup.agree_terms

data class AgreeTermsState (
    val isNextButtonEnabled: Boolean = false,
    val isAllTermsAgreed: Boolean = false,
    val isDialogShow: Boolean = false,
    val isAgreeTerms:List<Boolean> = listOf(false,false,false,false)


)