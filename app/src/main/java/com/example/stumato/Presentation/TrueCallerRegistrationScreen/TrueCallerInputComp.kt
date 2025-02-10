package com.example.stumato.Presentation.TrueCallerRegistrationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.stumato.Presentation.ManualRegistrationScreen.InputBox
import com.example.stumato.Viewmodel.TrueCallerRegistrationViewmodel


@Composable
fun TrueCallerForm(navController: NavController,
                   activity: FragmentActivity,
                   viewmodel: TrueCallerRegistrationViewmodel,
                   modifier: Modifier = Modifier) {
    var firstName = remember {mutableStateOf("")}
    val lastName = remember { mutableStateOf("") }
    val mobileNumber = remember { mutableStateOf("") }

    Column(modifier= modifier) {
        TrueCallerRegistrationButton(modifier= Modifier.fillMaxWidth(0.6f))

        Spacer(modifier= Modifier.padding(vertical = 50.dp))

        InputBox(
            value = firstName.value,
            onvaluechange = { firstName.value = it },
            placeholder = "First Name",
            modifier = Modifier.fillMaxWidth(0.6f)
        )

        Spacer(modifier= Modifier.padding(vertical = 4.dp))

        InputBox(
            value = lastName.value,
            onvaluechange = { lastName.value = it },
            placeholder = "Last Name",
            modifier = Modifier.fillMaxWidth(0.6f)
        )

        Spacer(modifier= Modifier.padding(vertical = 4.dp))

        InputBox(
            value = mobileNumber.value,
            onvaluechange = { mobileNumber.value = it },
            placeholder = "Mobile Number",
            modifier = Modifier.fillMaxWidth(0.6f)
        )

        Spacer(modifier= Modifier.padding(vertical = 25.dp))

        TrueCallerProceedButton(
            onProceedClick = {
            },
            modifier= Modifier.fillMaxWidth(0.6f))

        Spacer(modifier= Modifier.padding(vertical = 40.dp))

    }
}
