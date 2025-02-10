package com.example.stumato.Presentation.TrueCallerRegistrationScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.stumato.Viewmodel.TrueCallerRegistrationViewmodel
import com.truecaller.android.sdk.oAuth.TcSdk

@SuppressLint("ContextCastToActivity")
@Composable
fun TrueCallerRegistrationScreen(activity : FragmentActivity,
                                 navController: NavController,
                                 viewmodel: TrueCallerRegistrationViewmodel= hiltViewModel(),
                                 modifier: Modifier = Modifier) {

    val context = LocalContext.current
//Truecaller sdk invoking
    LaunchedEffect(Unit) {
       viewmodel.initTruecallerSDK(context)
        if(TcSdk.getInstance().isOAuthFlowUsable){
            viewmodel.startTruecallerAuth(activity)
        }
    }

    Box (modifier.fillMaxSize()){
        TrueCallerForm(navController,
            viewmodel,
            modifier= Modifier.align(Alignment.Center))
    }
}




