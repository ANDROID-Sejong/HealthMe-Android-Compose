package com.example.healthmeconverttocomposablecode.core.routing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.healthmeconverttocomposablecode.presentation.auth.login.LoginScreen
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.agree_terms.AgreeTermsRoot
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_email.SetEmailRoot
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_information.SetInformationRoot
import com.example.healthmeconverttocomposablecode.presentation.auth.signup.set_password.SetPasswordRoot
import com.example.healthmeconverttocomposablecode.presentation.splash.SplashScreen

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
                SetEmailRoot(onNextButtonClick = {
                    topLevelBackStack.clear()
                    topLevelBackStack.add(Route.SetPassword(it))
                })
            }
            entry<Route.SetPassword> {
                SetPasswordRoot(it.email, onNextButtonClick = { email, password ->
                    topLevelBackStack.clear()
                    topLevelBackStack.add(Route.SetInformation(email = email, password = password))
                })
            }
            entry<Route.SetInformation> {
                SetInformationRoot(
                    email = it.email,
                    password = it.password,
                    onNextButtonClick = { email, password, name, birthDate, gender, height, weight ->
                        topLevelBackStack.clear()
                        topLevelBackStack.add(
                            Route.AgreeTerms(
                                email = email,
                                password = password,
                                name = name,
                                birthDate = birthDate,
                                gender = gender,
                                height = height,
                                weight = weight
                            )
                        )
                    }
                )
            }
            entry<Route.AgreeTerms> {
                AgreeTermsRoot()


            }
            entry<Route.Login> {
                LoginScreen() {
                }
            }
        }

    )


}
