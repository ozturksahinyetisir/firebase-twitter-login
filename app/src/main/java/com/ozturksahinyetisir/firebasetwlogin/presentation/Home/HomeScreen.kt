package com.ozturksahinyetisir.firebasetwlogin.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozturksahinyetisir.firebasetwlogin.social.twitter.AuthViewModel


@Composable
fun HomeScreen(authViewModel: AuthViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "HomePage",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        RedSignOutButton(onClick = {authViewModel.signOut()})
    }
}

@Composable
fun RedSignOutButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(Color.Red),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(text = "Sign Out", color = MaterialTheme.colorScheme.onPrimary)
    }
}