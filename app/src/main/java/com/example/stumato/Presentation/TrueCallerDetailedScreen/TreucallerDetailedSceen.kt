package com.example.stumato.Presentation.TrueCallerDetailedScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.stumato.Presentation.DatailedScreen.Info
import com.example.stumato.Viewmodel.DetailScreenViewmodel
import com.example.stumato.Viewmodel.TrueCallerScreenViewmodel


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    TrueCallerDetailScreen(navController = rememberNavController())
}

@Composable
fun TrueCallerDetailScreen(navController: NavController,
                 modifier: Modifier = Modifier) {
    val viewmodel : TrueCallerScreenViewmodel = hiltViewModel()
    val userstate = viewmodel.userInfo.collectAsState()
    Box (modifier.fillMaxSize()){
        Info(userstate.value,
            navController,
            modifier= Modifier.align(Alignment.Center))
    }

}


