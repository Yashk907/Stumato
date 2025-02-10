package com.example.stumato.Presentation.TrueCallerRegistrationScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
