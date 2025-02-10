package com.example.stumato

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import com.example.stumato.Navigation.Navigation
import com.example.stumato.ui.theme.StumatoTheme
import com.truecaller.android.sdk.oAuth.TcSdk
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,

    ) {
        super.onActivityResult(requestCode, resultCode, data)
        // Pass the result to Truecaller SDK
        TcSdk.getInstance().onActivityResultObtained(this, requestCode, resultCode, data)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StumatoTheme {
                val activity = this
                Navigation(activity)
            }
        }
    }
}

