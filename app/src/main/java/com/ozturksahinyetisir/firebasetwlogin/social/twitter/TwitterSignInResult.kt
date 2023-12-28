package com.ozturksahinyetisir.firebasetwlogin.social.twitter

sealed class TwitterSignInResult {
    data class Success(val data: UserData) : TwitterSignInResult()
    data class Error(val errorMessage: String) : TwitterSignInResult()
}

    data class UserData(
        val userId: String,
        val username: String?
    )

