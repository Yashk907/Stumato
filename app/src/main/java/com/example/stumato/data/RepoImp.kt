package com.example.stumato.data

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.stumato.Api.TrueCallerApi
import com.example.stumato.model.AccessTokenResponse
import com.example.stumato.model.User
import com.example.stumato.model.UserProfileResponse
import com.truecaller.android.sdk.oAuth.TcOAuthCallback
import com.truecaller.android.sdk.oAuth.TcOAuthData
import com.truecaller.android.sdk.oAuth.TcOAuthError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class RepoImp @Inject constructor(private val api: TrueCallerApi) : Repo {
    private val _user = MutableStateFlow(User())
    val user = _user
    override suspend fun RegisterUserManual(user: User) {
        _user.value=user
    }

    override suspend fun fetchUserWithoneclick(user: User){
        _user.value=user
    }

    suspend fun getAccessToken(clientId: String, authCode: String, codeVerifier: String): AccessTokenResponse? {
        return withContext(Dispatchers.IO) {
            val response = api.fetchAccessToken(
                clientId = clientId,
                authCode = authCode,
                codeVerifier = codeVerifier
            )

            if (response.isSuccessful) {
                response.body()
            } else {
                Log.d("accesstoken","Failed at repo")
            null// Handle API failure
            }
        }
    }

    suspend fun getUserProfile(accesscode : String): UserProfileResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.fetchUserInfo("Bearer $accesscode")

                if (response.isSuccessful) {
                    response.body().also {
                        Log.d("TrueCallerRepo", "User Profile: ${it?.given_name} ${it?.family_name}")
                    }
                } else {
                    Log.e("TrueCallerRepo", "Error: ${response.errorBody()?.string()}")
                    null
                }
            } catch (e: HttpException) {
                Log.e("TrueCallerRepo", "HTTP Error: ${e.message}")
                null
            } catch (e: Exception) {
                Log.e("TrueCallerRepo", "Exception: ${e.message}")
                null
            }
        }
    }
}