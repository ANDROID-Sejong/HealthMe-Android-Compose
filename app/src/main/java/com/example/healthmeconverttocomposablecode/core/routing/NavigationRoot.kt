package com.example.healthmeconverttocomposablecode.core.routing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.healthmeconverttocomposablecode.presentation.auth.login.LoginScreen
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_email.SetEmailRoot
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_password.SetPasswordScreen
import com.example.healthmeconverttocomposablecode.presentation.auth.splash.SplashScreen

@Composable
fun NavigationRoot(modifier: Modifier = Modifier) {

    val topLevelBackStack = rememberNavBackStack(Route.Splash)

    NavDisplay(
        modifier = modifier,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        backStack = topLevelBackStack,
        entryProvider = entryProvider {
            entry<Route.Splash> {
                SplashScreen(
                    onLoginButtonClick = {
                        topLevelBackStack.clear()
                        topLevelBackStack.add(Route.Login)
                    },
                    onSignUpButtonClick = {
                        topLevelBackStack.clear()
                        topLevelBackStack.add(Route.SetEmail)
                    })
            }
            entry<Route.SetEmail> {
                SetEmailRoot()
            }
            entry<Route.SetPassword> {
                SetPasswordScreen()
            }
            entry<Route.Login> {
                LoginScreen() {
                }
            }
        }

    )


}
