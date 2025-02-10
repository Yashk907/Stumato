package com.example.stumato.Viewmodel

import android.R.attr.fragment
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.example.stumato.data.RepoImp
import com.example.stumato.model.User
import com.truecaller.android.sdk.oAuth.CodeVerifierUtil
import com.truecaller.android.sdk.oAuth.TcOAuthCallback
import com.truecaller.android.sdk.oAuth.TcOAuthData
import com.truecaller.android.sdk.oAuth.TcOAuthError
import com.truecaller.android.sdk.oAuth.TcSdk
import com.truecaller.android.sdk.oAuth.TcSdkOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.shadow.apache.commons.lang3.ObjectUtils.Null
import java.math.BigInteger
import java.security.SecureRandom
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class TrueCallerRegistrationViewmodel @Inject constructor(private val repoImp: RepoImp) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    val stateRequested = BigInteger(130, SecureRandom()).toString(32)

    private val tcOAuthCallback: TcOAuthCallback = object : TcOAuthCallback {
        override fun onSuccess(tcOAuthData: TcOAuthData) {
            //implementation
        }

        override fun onVerificationRequired(tcOAuthError: TcOAuthError?) {
            TODO("Not yet implemented")
        }

        override fun onFailure(tcOAuthError: TcOAuthError) {
            Log.e("TrueCaller", "Truecaller authentication failed: ${tcOAuthError.errorMessage}")
        }
    }


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


    fun startTruecallerAuth(activity: FragmentActivity) {
        val isUsable = TcSdk.getInstance().isOAuthFlowUsable
        Log.d("state",stateRequested.toString())
        if (isUsable) {
            TcSdk.getInstance().setOAuthState(stateRequested)
            TcSdk.getInstance().setOAuthScopes(arrayOf("profile"))
            val codeVerifier = CodeVerifierUtil.generateRandomCodeVerifier()
            Log.d("state",codeVerifier.toString())
            val codeChallenge = CodeVerifierUtil.getCodeChallenge(codeVerifier)
            codeChallenge?.let {
                TcSdk.getInstance().setCodeChallenge(it)
            } ?: Log.e("TrueCaller", "Code challenge is null")

            TcSdk.getInstance().getAuthorizationCode(activity)

        } else {
            Log.e("TrueCaller", "Truecaller SDK is not usable")
        }

    }


}
