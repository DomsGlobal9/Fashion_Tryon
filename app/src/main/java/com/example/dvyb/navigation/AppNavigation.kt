package com.example.dvyb.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
//import com.example.dvyb.ui.theme.components.screens.getstarted.GetStartedScreen
import com.example.dvyb.ui.theme.components.screens.login.LoginScreen
import com.example.dvyb.ui.theme.components.screens.login.PasswordResetScreen
import com.example.dvyb.ui.theme.components.screens.onboarding.OnboardingScreen

//import com.example.dvyb.ui.theme.components.screens.getstarted.GetStartedScreen
//import com.example.dvyb.ui.theme.components.screens.login.LoginScreen
//import com.example.dvyb.ui.theme.components.screens.onboarding.OnboardingScreen
//import com.example.dvyb.ui.theme.components.screens.splash.SplashScreen
import com.example.dvyb.ui.theme.components.screens.splash.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("onboarding/{step}",
            arguments = listOf(navArgument("step") { type = NavType.IntType })
        ) {
            val step = it.arguments?.getInt("step") ?: 0
            OnboardingScreen(navController, step)
        }
//        composable("get_started") { GetStartedScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("forgot_password") { PasswordResetScreen(navController) }
    }
}