package com.example.stumato.Presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.stumato.Navigation.Screen

//@Preview(showSystemUi = true)
@Composable
fun HomeScreen(navController: NavController,
               modifier: Modifier = Modifier) {
    Box (modifier=modifier.fillMaxSize()){
        Column (modifier= Modifier.align(Alignment.Center)){
            RegistrationButton(onclick = {navController.navigate(Screen.MANUALREGISTER.name)},
                name = "Manual Registration",
                modifier= Modifier.fillMaxWidth(0.6f))
            Spacer(modifier= Modifier.padding(vertical = 30.dp))
            RegistrationButton(onclick = { navController.navigate(Screen.TRUECALLERREGISTER.name) },
                name = "1-click Registration",
                modifier= Modifier.fillMaxWidth(0.6f))
        }
    }
}

@Preview
@Composable
fun RegistrationButton(
    onclick : ()-> Unit={},
    name : String="Manual Registration",
    buttonColor : Color =Color(0xFFe2e2e2),
    modifier: Modifier = Modifier) {
    OutlinedButton(onClick = onclick,
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