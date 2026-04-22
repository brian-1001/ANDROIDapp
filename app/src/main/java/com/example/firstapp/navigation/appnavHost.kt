package com.example.firstapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.screens.dashboard.DashboardScreen
import com.example.firstapp.screens.demo.FirstScreen
import com.example.firstapp.screens.login.LoginScreen
import com.example.firstapp.screens.products.AddProductScreen
import com.example.firstapp.screens.products.ProductListScreen
import com.example.firstapp.screens.register.RegisterScreen
import com.example.firstapp.screens.splashscreens.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUTE_FIRSTSCREEN) {
            FirstScreen(navController)
        }
        composable(ROUTE_PRODUCTLIST) {
            ProductListScreen(navController)
        }
        composable(ROUTE_ADDPRODUCTS) {
            AddProductScreen(navController)
        }
    }
}
