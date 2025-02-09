package com.example.stumato.Presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.stumato.Navigation.Screen
import com.example.stumato.Viewmodel.DetailScreenViewmodel
import com.example.stumato.model.User

//@Preview(showSystemUi = true)
@Composable
fun DetailScreen(navController: NavController,
                 modifier: Modifier = Modifier) {
    val viewmodel : DetailScreenViewmodel = hiltViewModel()
    val userstate = viewmodel.userInfo.collectAsState()
    Box (modifier.fillMaxSize()){
        Info(userstate.value,
            navController,
            modifier= Modifier.align(Alignment.Center))
    }
}

@Composable
fun Info(user: User,
         navController: NavController,
         modifier: Modifier = Modifier) {
    Column(modifier= modifier) {
        RegistrationButton(name = "SUCCESS",
            modifier= Modifier.fillMaxWidth(0.6f))
        Spacer(modifier= Modifier.padding(vertical = 50.dp))
        InfoBox(text = user.firstName?:"N/A", modifier= Modifier.fillMaxWidth(0.6f))
        Spacer(modifier= Modifier.padding(vertical = 4.dp))
        InfoBox(text = user.lastName?:"N/A", modifier= Modifier.fillMaxWidth(0.6f))
        Spacer(modifier= Modifier.padding(vertical = 4.dp))
        InfoBox(text = user.mobileNumber?:"N/A", modifier= Modifier.fillMaxWidth(0.6f))
        Spacer(modifier= Modifier.padding(vertical = 25.dp))
        HomeButton(onclick = {navController.navigate(Screen.HOMESCREEN.name)},
            modifier= Modifier.fillMaxWidth(0.6f))
        Spacer(modifier= Modifier.padding(vertical = 40.dp))

    }
}

@Preview
@Composable
fun InfoBox(text : String ="Riya",
            modifier: Modifier = Modifier) {
    Box (modifier=modifier.border(1.dp,Color.Black)){
        Text(text,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(TextFieldDefaults.contentPaddingWithoutLabel()))
    }
}

@Preview
@Composable
fun HomeButton(onclick : ()->Unit ={},
               buttonName : String ="HOME",
               buttonColor : Color =Color(0xFFc2eab6),
               modifier: Modifier = Modifier) {
    OutlinedButton(onClick = onclick,
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(buttonColor),
        border = BorderStroke(0.dp, buttonColor),
        modifier = modifier) {
        Text(buttonName,
            fontSize = 18.sp,
            color = Color.Black)
    }
}
