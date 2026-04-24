package com.example.firstapp.screens.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.data.AuthViewModel
import com.example.firstapp.navigation.ROUTE_ADDPRODUCTS
import com.example.firstapp.navigation.ROUTE_PRODUCTLIST
import com.example.firstapp.navigation.ROUTE_PROFILE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController){
    val context = LocalContext.current
    val myauth = AuthViewModel(navController, context)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MY APP") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Blue,
                ),
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "settings icon"
                        )
                    }
                    IconButton(onClick = { myauth.logout() }) {
                        Icon(
                            Icons.Default.ExitToApp,
                            contentDescription = "logout icon"
                        )
                    }
                }
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ) {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = "Home icon"
                            )
                        },
                        label = { Text("Home") }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate(ROUTE_PROFILE) },
                        icon = {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "Person icon"
                            )
                        },
                        label = { Text("Profile") }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = "Settings icon"
                            )
                        },
                        label = { Text("Settings") }
                    )
                }
            }
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text("Welcome to my app", modifier = Modifier.padding(16.dp))

            var username by remember { mutableStateOf("Loading...") }
            LaunchedEffect(Unit) {
                myauth.getCurrentUserName {
                    username = it
                }
            }

            Text(text = "Welcome, $username ", modifier = Modifier.padding(horizontal = 16.dp))
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Card 1: Add Product
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                        .clickable {
                        navController.navigate(ROUTE_ADDPRODUCTS)
                        },
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
                        Text("add product", color = Color.Blue, fontSize = 24.sp)
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "icon",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                // Card 2: Product List
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                        .clickable {
                            navController.navigate(ROUTE_PRODUCTLIST)
                        },
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
                        Text("product list", color = Color.Blue, fontSize = 24.sp)
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "icon",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                // Card 3: My Profile
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                        .clickable {
                            navController.navigate(ROUTE_PROFILE)
                        },
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
                        Text("my profile", color = Color.Blue, fontSize = 24.sp)
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "icon",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun DashboardPreview(){
    DashboardScreen(rememberNavController())
}
