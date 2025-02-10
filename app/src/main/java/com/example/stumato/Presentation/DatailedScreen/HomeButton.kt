package com.example.stumato.Presentation.DatailedScreen

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
