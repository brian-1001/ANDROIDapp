package com.example.firstapp.screens.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstapp.R

@Composable
fun BoxScreen(){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.teaplantation),
            contentDescription = "background image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "welcome to my app",
            color = Color.Black,
            fontSize = 58.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.align(Alignment.Center)
        )
    }

}
@Preview(showBackground = true)
@Composable
fun boxpreview(){
    BoxScreen()
}