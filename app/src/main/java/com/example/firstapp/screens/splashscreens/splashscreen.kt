package com.example.firstapp.screens.splashscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.R
import com.example.firstapp.navigation.ROUTE_FIRSTSCREEN
import kotlinx.coroutines.delay

@Composable
fun  SplashScreen(navController: NavHostController){
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(ROUTE_FIRSTSCREEN)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
        contentAlignment = Alignment.Center

    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id=R.drawable.flower),
                contentDescription = "logo",
                modifier = Modifier
                    .size(350.dp)
                    .clip(CircleShape)
            )
            Text(text = "welcome to my app",
                color = Color.Red,
                fontSize = 24.sp
            )
        }
    }

}
@Preview
@Composable
fun splashpreview(){
    SplashScreen(rememberNavController())
}