package com.example.stumato.Presentation

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
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.stumato.Navigation.Screen
import com.example.stumato.Viewmodel.ManualRegistrationViewmodel

//@Preview(showSystemUi = true)
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


@Composable
fun Form(navController: NavController,
         viewmodel: ManualRegistrationViewmodel,
         modifier: Modifier = Modifier) {
    var firstName = remember {mutableStateOf("")}
    val lastName = remember { mutableStateOf("") }
    val mobileNumber = remember { mutableStateOf("") }

    Column(modifier= modifier) {
        RegistrationButton(modifier= Modifier.fillMaxWidth(0.6f))

        Spacer(modifier= Modifier.padding(vertical = 50.dp))

        InputBox(value = firstName.value,
            onvaluechange = {firstName.value=it},
            placeholder = "First Name",
            modifier= Modifier.fillMaxWidth(0.6f))

        Spacer(modifier= Modifier.padding(vertical = 4.dp))

        InputBox(value = lastName.value,
            onvaluechange = {lastName.value=it},
            placeholder = "Last Name",
            modifier= Modifier.fillMaxWidth(0.6f))

        Spacer(modifier= Modifier.padding(vertical = 4.dp))

        InputBox(value = mobileNumber.value,
            onvaluechange = {mobileNumber.value=it},
            placeholder = "Mobile Number",
            modifier= Modifier.fillMaxWidth(0.6f))

        Spacer(modifier= Modifier.padding(vertical = 25.dp))

        ProceedButton(
            onProceedClick = {
                viewmodel.ManualRegister(firstName = firstName.value,
                    lastName = lastName.value,
                    mobileNumber = mobileNumber.value)
                navController.navigate(Screen.DETAILSCREEN.name)
            },
            modifier= Modifier.fillMaxWidth(0.6f))

        Spacer(modifier= Modifier.padding(vertical = 40.dp))

    }
}

@Preview
@Composable
fun InputBox(value : String ="",
             onvaluechange : (String)-> Unit={},
             placeholder : String="First Name",
             modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = value,
        onValueChange = onvaluechange,
        shape = RoundedCornerShape(0.dp),
        placeholder = {
            Text(text = placeholder,
            color = Color.Gray) },
        modifier= modifier
    )
}

@Preview
@Composable
fun ProceedButton(
                  onProceedClick: () -> Unit={},
                  buttonColor : Color = Color(0xFFc5dcfb),
                  modifier: Modifier = Modifier) {
    Button(
        onClick = onProceedClick,
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(buttonColor),
        modifier = modifier
    ) {
        Row (modifier= Modifier.align(Alignment.CenterVertically)){
            Text("PROCEED",
                color = Color.Black,
                fontSize = 18.sp,
                modifier= Modifier.align(Alignment.CenterVertically))
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                "forward arrow",
                tint = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}