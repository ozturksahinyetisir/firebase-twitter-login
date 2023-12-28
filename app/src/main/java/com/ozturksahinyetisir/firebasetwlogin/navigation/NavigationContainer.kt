package com.ozturksahinyetisir.firebasetwlogin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ozturksahinyetisir.firebasetwlogin.presentation.Home.HomeScreen
import com.ozturksahinyetisir.firebasetwlogin.presentation.Login.LoginScreen
import com.ozturksahinyetisir.firebasetwlogin.presentation.Twitter.TwitterSignInScreen
import com.ozturksahinyetisir.firebasetwlogin.social.twitter.AuthViewModel

@Composable
fun NavigationContainer(navController:NavHostController,
){
    NavHost(navController = navController, startDestination = "login_screen" ){
        composable("login_screen"){
            LoginScreen(navController)
        }
        composable("twitter_screen"){
            TwitterSignInScreen(viewModel = AuthViewModel())
        }
        composable("home_screen"){
            HomeScreen()
        }

    }
}