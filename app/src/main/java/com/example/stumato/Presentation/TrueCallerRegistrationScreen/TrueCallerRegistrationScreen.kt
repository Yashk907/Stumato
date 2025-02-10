package com.example.stumato.Presentation.TrueCallerRegistrationScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.stumato.Presentation.ManualRegistrationScreen.InputBox
import com.example.stumato.Viewmodel.TrueCallerRegistrationViewmodel
import com.truecaller.android.sdk.oAuth.TcSdk

@SuppressLint("ContextCastToActivity")
@Composable
fun TrueCallerRegistrationScreen(activity : FragmentActivity,
                                 navController: NavController,
                                 viewmodel: TrueCallerRegistrationViewmodel= hiltViewModel(),
                                 modifier: Modifier = Modifier) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
       viewmodel.initTruecallerSDK(context)
        if(TcSdk.getInstance().isOAuthFlowUsable){
            viewmodel.startTruecallerAuth(activity)
        }
    }
    Box (modifier.fillMaxSize()){
        TrueCallerForm(navController,
            activity,
            viewmodel,
            modifier= Modifier.align(Alignment.Center))
    }
}


@Preview
@Composable
fun TrueCallerRegistrationButton(
    enable : Boolean=true,
    onclick : ()-> Unit={},
    name : String="Manual Registration",
    buttonColor : Color =Color(0xFFe2e2e2),
    modifier: Modifier = Modifier) {
    OutlinedButton(onClick = onclick,
        enabled = enable,
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(buttonColor),
        modifier = modifier
    ) {
        Text(text = name,
            color = Color.Black,
            fontSize = 18.sp)
    }
}


