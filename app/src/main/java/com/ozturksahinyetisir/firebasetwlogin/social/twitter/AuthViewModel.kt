package com.ozturksahinyetisir.firebasetwlogin.social.twitter

import android.app.Activity
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    fun signInWithTwitter(context : Context): LiveData<TwitterSignInResult> {
        val resultLiveData = MutableLiveData<TwitterSignInResult>()

        val provider = OAuthProvider.newBuilder("twitter.com").build()
        auth.startActivityForSignInWithProvider(context as Activity,provider)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    resultLiveData.value = TwitterSignInResult.Success(
                        UserData(
                            userId = user?.uid.orEmpty(),
                            username = user?.displayName.orEmpty()
                        )
                    )
                } else {
                    resultLiveData.value = TwitterSignInResult.Error(
                        task.exception?.message ?: "Sign-In process failed"
                    )
                }
            }
        return resultLiveData
    }

    fun signOut(){
        auth.signOut()
    }
}