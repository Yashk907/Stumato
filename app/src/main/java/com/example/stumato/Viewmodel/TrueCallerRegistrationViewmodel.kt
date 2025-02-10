package com.example.stumato.Viewmodel

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stumato.data.RepoImp
import com.example.stumato.model.AccessTokenResponse
import com.example.stumato.model.User
import com.example.stumato.model.UserProfileResponse
import com.truecaller.android.sdk.oAuth.CodeVerifierUtil
import com.truecaller.android.sdk.oAuth.TcOAuthCallback
import com.truecaller.android.sdk.oAuth.TcOAuthData
import com.truecaller.android.sdk.oAuth.TcOAuthError
import com.truecaller.android.sdk.oAuth.TcSdk
import com.truecaller.android.sdk.oAuth.TcSdkOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.SecureRandom
import javax.inject.Inject

@HiltViewModel
class TrueCallerRegistrationViewmodel @Inject constructor(private val repoImp: RepoImp) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _userProfile = MutableStateFlow<UserProfileResponse?>(null)
    val userProfile: StateFlow<UserProfileResponse?> = _userProfile


    val stateRequested = BigInteger(130, SecureRandom()).toString(32)
    private var codeVerifier: String = ""

    private val tcOAuthCallback: TcOAuthCallback = object : TcOAuthCallback {
        override fun onSuccess(tcOAuthData: TcOAuthData) {
            Log.d("TrueCaller","success!!!!!!!!!!!!!!!!!!!!!!!!!!")
            val authorizationCode = tcOAuthData.authorizationCode
            fetchAccessToken(authCode = authorizationCode)
        }

        override fun onVerificationRequired(tcOAuthError: TcOAuthError?) {
            TODO("Not yet implemented")
        }

        override fun onFailure(tcOAuthError: TcOAuthError) {
            Log.e("TrueCaller", "Truecaller authentication failed: ${tcOAuthError.errorMessage}")
        }
    }

    fun fetchuser(firstName : String,
                                lastName : String,
                                mobileNumber : String){
        val user = User(
            firstName=firstName,
            lastName = lastName,
            mobileNumber = mobileNumber
        )
        viewModelScope.launch{
            repoImp.fetchUserWithoneclick(user)
        }


    }

//initiating the truecallersdk
    fun initTruecallerSDK(context: Context) {
        val tcSdkOptions = TcSdkOptions.Builder(context, tcOAuthCallback)
            .buttonColor(Color.BLUE)
            .buttonTextColor(Color.WHITE)
            .loginTextPrefix(TcSdkOptions.LOGIN_TEXT_PREFIX_TO_CONTINUE)
            .ctaText(TcSdkOptions.CTA_TEXT_CONTINUE)
            .buttonShapeOptions(TcSdkOptions.BUTTON_SHAPE_ROUNDED)
            .footerType(TcSdkOptions.FOOTER_TYPE_SKIP)
            .consentTitleOption(TcSdkOptions.SDK_CONSENT_HEADING_SIGN_UP_WITH)
            .sdkOptions(TcSdkOptions.OPTION_VERIFY_ONLY_TC_USERS)
            .build();

        TcSdk.init(tcSdkOptions)
    }

//start the sdk invoking on screens
    fun startTruecallerAuth(activity: FragmentActivity) {
        val isUsable = TcSdk.getInstance().isOAuthFlowUsable

        if (isUsable) {
            TcSdk.getInstance().setOAuthState(stateRequested)
            TcSdk.getInstance().setOAuthScopes(arrayOf("profile","phone"))
             codeVerifier = CodeVerifierUtil.generateRandomCodeVerifier()
            val codeChallenge = CodeVerifierUtil.getCodeChallenge(codeVerifier)
            codeChallenge?.let {
                TcSdk.getInstance().setCodeChallenge(it)
            } ?: Log.e("TrueCaller", "Code challenge is null")

            TcSdk.getInstance().getAuthorizationCode(activity)


        } else {
            Log.e("TrueCaller", "Truecaller SDK is not usable")
        }

    }

    //fetching access token
    private fun fetchAccessToken(authCode: String) {
        viewModelScope.launch{
            val clientId = "znexfsjzbbwhtt3ofhkyjqu0z1wghvvzpgxsjtdjcug"
            val response = repoImp.getAccessToken(clientId, authCode, codeVerifier)
            Log.d("accesstoken", response?.access_token ?: "null")

            response?.let {
                Log.d("TrueCaller", "Access Token: ${it.access_token}")
                // Fetch User Profile
                fetchUserProfile(it.access_token)
            } ?: Log.e("TrueCaller", "Failed to fetch access token")
        }
    }

    //fetching user profile
    private fun fetchUserProfile(accessToken: String) {
        viewModelScope.launch {
            val userProfile = repoImp.getUserProfile(accessToken)
            _userProfile.value = userProfile
            } ?: Log.e("TrueCaller", "Failed to fetch user profile")

    }


}
