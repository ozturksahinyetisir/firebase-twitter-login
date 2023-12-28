package com.ozturksahinyetisir.firebasetwlogin.presentation.Twitter

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ozturksahinyetisir.firebasetwlogin.social.twitter.AuthViewModel
import com.ozturksahinyetisir.firebasetwlogin.social.twitter.TwitterSignInResult

@Composable
fun TwitterSignInScreen(
    viewModel: AuthViewModel,
    navController: NavController = rememberNavController(),
) {
    val context = LocalContext.current
    val signInResult by viewModel.signInWithTwitter(context).observeAsState()


    when (val signInResult = signInResult) {
        is TwitterSignInResult.Success -> {
            val user = signInResult.data
            if (user != null) {
                // Giriş başarılıysa, ana ekrana geç
                navController.navigate("home_screen")
            } else {
                // Giriş başarılı & sistemsel sorun var ise, hata mesajını göster
                val errorMessage = signInResult.data
                errorMessage?.let {
                    Toast.makeText(context,"Error has occurred!",Toast.LENGTH_LONG).show()
                }
            }
        }
        is TwitterSignInResult.Error -> {
            // Giriş başarısız olursa hata durumunu ekranda göster
            val errorMessage = signInResult.errorMessage
            errorMessage?.let {
                Toast.makeText(context, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
            }
        }
        else -> {
            LoadingScreen()
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}