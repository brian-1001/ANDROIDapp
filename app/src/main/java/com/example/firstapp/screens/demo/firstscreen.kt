package com.example.firstapp.screens.demo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.navigation.ROUTE_LOGIN
import com.example.firstapp.navigation.ROUTE_REGISTER

@Composable
fun FirstScreen(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.LightGray)
            .padding(20.dp)
    ) {
        Text(text="welcome to my app",
            fontSize = 52.sp,
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id= R.drawable.flower),
            contentDescription = "company logo",
            modifier = Modifier.height(400.dp)
                .fillMaxWidth()

        )
        //row with two buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =Arrangement.SpaceEvenly
        ){
            Button(onClick = {
                navController.navigate(ROUTE_LOGIN)
            }) {
                Text("LOGIN")
            }
            Button(onClick = {
                navController.navigate(ROUTE_REGISTER)
            }) {
                Text("REGISTER")
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun FirstScreenPreview(){
    FirstScreen(rememberNavController())
}
