package com.example.stumato.Presentation.ManualRegistrationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stumato.Navigation.Screen
import com.example.stumato.Presentation.HomeScreen.RegistrationButton
import com.example.stumato.Viewmodel.ManualRegistrationViewmodel


@Composable
fun Form(navController: NavController,
         viewmodel: ManualRegistrationViewmodel,
         modifier: Modifier = Modifier) {
    var firstName = remember {mutableStateOf("")}
    val lastName = remember { mutableStateOf("") }
    val mobileNumber = remember { mutableStateOf("") }

    Column(modifier= modifier) {
        //using registrationButtonInHomescreen file
        RegistrationButton(enable = false, modifier = Modifier.fillMaxWidth(0.6f))

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

        if (firstName.value.isNotEmpty() && lastName.value.isNotEmpty() && mobileNumber.value.isNotEmpty()){
            ProceedButton(
                onProceedClick = {
                    viewmodel.ManualRegister(firstName = firstName.value,
                        lastName = lastName.value,
                        mobileNumber = mobileNumber.value)
                    navController.navigate(Screen.DETAILSCREEN.name)
                },
                modifier= Modifier.fillMaxWidth(0.6f))
        }

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
                color = Color.Black) },
        modifier= modifier
    )
}
