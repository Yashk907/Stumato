package com.example.stumato.data

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.stumato.model.User
import com.truecaller.android.sdk.oAuth.TcOAuthCallback
import com.truecaller.android.sdk.oAuth.TcOAuthData
import com.truecaller.android.sdk.oAuth.TcOAuthError
import kotlinx.coroutines.flow.MutableStateFlow

class RepoImp : Repo {
    private val _user = MutableStateFlow(User())
    val user = _user
    override suspend fun RegisterUserManual(user: User) {
        _user.value=user
    }

    override suspend fun RegisterUser1Click(user: User) {
       //coding
    }

    //trueCallerLogic
    private val tcOAuthCallback = object  : TcOAuthCallback{
        override fun onFailure(tcOAuthError: TcOAuthError) {
            _user.value= User()
        }

        override fun onSuccess(tcOAuthData: TcOAuthData) {
            Log.d("yash",tcOAuthData.scopesGranted.toString())
        }

        override fun onVerificationRequired(tcOAuthError: TcOAuthError?) {
            TODO("Not yet implemented")
        }

    }
}