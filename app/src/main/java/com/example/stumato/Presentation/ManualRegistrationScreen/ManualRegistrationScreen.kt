package com.example.stumato.Presentation.ManualRegistrationScreen

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.stumato.Navigation.Screen
import com.example.stumato.Presentation.HomeScreen.RegistrationButton
import com.example.stumato.Viewmodel.ManualRegistrationViewmodel

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    ManualRegistrationScreen(navController = rememberNavController())
}

@Composable
fun ManualRegistrationScreen(navController: NavController,
                             modifier: Modifier = Modifier) {
    val viewmodel : ManualRegistrationViewmodel = hiltViewModel()
    Box (modifier.fillMaxSize()){
        Form(navController=navController,
            viewmodel,
            modifier= Modifier.align(Alignment.Center))
    }
}




