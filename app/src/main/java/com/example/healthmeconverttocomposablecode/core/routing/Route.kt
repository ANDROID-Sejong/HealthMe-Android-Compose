package com.example.healthmeconverttocomposablecode.core.routing

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Route : NavKey {
    @Serializable
    data object Splash : Route

    @Serializable
    data object SetEmail : Route

    @Serializable
    data object Login : Route

    @Serializable
    data class SetPassword(val email:String) : Route

    @Serializable
    data class SetInformation(val email:String, val password: String) : Route

}