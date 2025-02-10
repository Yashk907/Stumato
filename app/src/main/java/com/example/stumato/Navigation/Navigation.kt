package com.example.stumato.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stumato.Presentation.DatailedScreen.DetailScreen
import com.example.stumato.Presentation.HomeScreen.HomeScreen
import com.example.stumato.Presentation.ManualRegistrationScreen.ManualRegistrationScreen
import com.example.stumato.Presentation.TrueCallerRegistrationScreen.TrueCallerRegistrationScreen

enum class Screen{
    HOMESCREEN,
    MANUALREGISTER,
    DETAILSCREEN,
    TRUECALLERREGISTER
}
@Composable
fun Navigation(activity : FragmentActivity,
               modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Screen.HOMESCREEN.name){

        composable(route= Screen.HOMESCREEN.name){
            HomeScreen(navController)
        }

        composable(route = Screen.MANUALREGISTER.name){
            ManualRegistrationScreen(navController)
        }

        composable(route = Screen.DETAILSCREEN.name){
            DetailScreen(navController)
        }

        composable(route= Screen.TRUECALLERREGISTER.name){
            TrueCallerRegistrationScreen(activity,navController)
        }
    }
}