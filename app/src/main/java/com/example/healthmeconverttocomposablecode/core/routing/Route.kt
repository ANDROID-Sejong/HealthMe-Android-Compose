package com.example.healthmeconverttocomposablecode.core.routing

import androidx.navigation3.runtime.NavKey
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_information.GenderState
import kotlinx.serialization.Serializable

sealed interface Route : NavKey {
    @Serializable
    data object Splash : Route

    @Serializable
    data object SetEmail : Route

    @Serializable
    data object Login : Route

    @Serializable
    data class SetPassword(val email: String) : Route

    @Serializable
    data class SetInformation(val email: String, val password: String) : Route

    @Serializable
    data class AgreeTerms(
        val email: String,
        val password: String,
        val name: String,
        val birthDate: String,
        val gender: GenderState,
        val height: String,
        val weight: String
    ) : Route

    @Serializable
    data object CompleteSignup: Route

}