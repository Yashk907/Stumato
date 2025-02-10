package com.example.stumato.Presentation.ManualRegistrationScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun ProceedButton(enable : Boolean =true,
                  onProceedClick: () -> Unit={},
                  buttonColor : Color = Color(0xFFc5dcfb),
                  modifier: Modifier = Modifier) {
    Button(
        enabled = enable,
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