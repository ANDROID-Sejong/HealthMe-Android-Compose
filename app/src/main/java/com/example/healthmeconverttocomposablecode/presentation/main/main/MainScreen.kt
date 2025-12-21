package com.example.healthmeconverttocomposablecode.presentation.main.main

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.healthmeconverttocomposablecode.R
import com.example.healthmeconverttocomposablecode.core.routing.Route
import com.example.healthmeconverttocomposablecode.ui.AppColors
import com.example.healthmeconverttocomposablecode.ui.AppFonts

@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>,
    body: @Composable () -> Unit
) {
    val currentBackStack = backStack.lastOrNull()
    Scaffold(
        containerColor = AppColors.mainColor,//bottomnav 둥근 부분 아는 곳 메인컬러로 덮음.
        bottomBar = {
            Surface(
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            ) {
                NavigationBar(
                    containerColor = AppColors.bottomNavBackgroundColor
                ) {
                    NavigationBarItem(
                        selected = currentBackStack == Route.Exercise,
                        onClick = {
                            backStack.clear()
                            backStack.add(Route.Exercise)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.icon_bottom_nav_exercise),
                                contentDescription = "운동화면 아이콘",
                                tint = if (currentBackStack == Route.Exercise) {
                                    AppColors.bottomNavSelectedColor
                                } else {
                                    AppColors.bottomNavNotSelectedColor
                                }
                            )
                        },
                        label = {
                            Text(
                                "exercise",
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 7.sp,
                                color = AppColors.white
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    )
                    NavigationBarItem(
                        selected = currentBackStack == Route.Food,
                        onClick = {
                            backStack.clear()
                            backStack.add(Route.Food)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.icon_bottom_nav_food),
                                contentDescription = "음식화면 아이콘",
                                tint = if (currentBackStack == Route.Food) {
                                    AppColors.bottomNavSelectedColor
                                } else {
                                    AppColors.bottomNavNotSelectedColor
                                }
                            )
                        },
                        label = {
                            Text(
                                "food",
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 7.sp,
                                color = AppColors.white
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        interactionSource = remember { MutableInteractionSource() }

                    )
                    NavigationBarItem(
                        selected = currentBackStack == Route.Home,
                        onClick = {
                            backStack.clear()
                            backStack.add(Route.Home)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.icon_bottom_nav_home),
                                contentDescription = "홈화면 아이콘",
                                tint = if (currentBackStack == Route.Home) {
                                    AppColors.bottomNavSelectedColor
                                } else {
                                    AppColors.bottomNavNotSelectedColor
                                }
                            )
                        },
                        label = {
                            Text(
                                "home",
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 7.sp,
                                color = AppColors.white
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        interactionSource = remember { MutableInteractionSource() }

                    )
                    NavigationBarItem(
                        selected = currentBackStack == Route.Schedule,
                        onClick = {
                            backStack.clear()
                            backStack.add(Route.Schedule)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.icon_bottom_nav_schedule),
                                contentDescription = "일정화면 아이콘",
                                tint = if (currentBackStack == Route.Schedule) {
                                    AppColors.bottomNavSelectedColor
                                } else {
                                    AppColors.bottomNavNotSelectedColor
                                }
                            )
                        },
                        label = {
                            Text(
                                "schedule",
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 7.sp,
                                color = AppColors.white
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        interactionSource = remember { MutableInteractionSource() }

                    )
                    NavigationBarItem(
                        selected = currentBackStack == Route.MyPage,
                        onClick = {
                            backStack.clear()
                            backStack.add(Route.MyPage)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.icon_bottom_nav_mypage),
                                contentDescription = "마이페이지화면 아이콘",
                                tint = if (currentBackStack == Route.MyPage) {
                                    AppColors.bottomNavSelectedColor
                                } else {
                                    AppColors.bottomNavNotSelectedColor
                                }
                            )
                        },
                        label = {
                            Text(
                                "my page",
                                fontFamily = AppFonts.gmarketSans,
                                fontSize = 7.sp,
                                color = AppColors.white
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            body()
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen(rememberNavBackStack(Route.Home), {})
}