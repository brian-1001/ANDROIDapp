package com.example.firstapp.screens.dashboard

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(){
    Scaffold(
        //topbar
        topBar = {
            TopAppBar(
                title = {Text("MY APP")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.Blue,
                )
            )
        },
        //BOTTOM BAR
        bottomBar = {
            BottomAppBar(
               containerColor = Color.Magenta,
                contentColor = Color.Blue
            ) {
                NavigationBar() {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = { Icon(Icons.Default.Home,
                            contentDescription="Home icon")},
                        label = {Text("Home")}
                    )


                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = { Icon(Icons.Default.Person,
                            contentDescription="Person icon")},
                        label = {Text("Profile")}
                    )


                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = { Icon(Icons.Default.Settings,
                            contentDescription="Settings icon")},
                        label = {Text("Settings")}
                    )
                }
            }
        }


    ) {
        innerPadding->
        //COLUMN
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text("Welcome to my app")
            //card
            Card(modifier =Modifier
                .width(200.dp)
                .padding( 16.dp)
                .height(150.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("HELLO", color = Color.Blue, fontSize = 24.sp)
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "icon"
                    )
                }

            }
        }

    }

}
@Preview
@Composable
fun dashboardpeview(){
    DashboardScreen()
}
