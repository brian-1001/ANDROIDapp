package com.example.firstapp.screens.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.firstapp.data.ProductViewModel
import com.example.firstapp.models.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavHostController) {
    val context = LocalContext.current
    val productViewModel = ProductViewModel(navController, context)
    val emptyProductState = remember { mutableStateOf(Product()) }
    val products = remember { mutableStateListOf<Product>() }

    // Fix: Avoid calling Firebase methods in Preview mode as FirebaseApp is not initialized there.
    if (!LocalInspectionMode.current) {
        productViewModel.allProducts(emptyProductState, products)
    } else {
        // Add dummy data to show something in the Preview
        if (products.isEmpty()) {
            products.add(
                Product(
                    name = "Sample Product",
                    price = "100",
                    description = "This is a sample description for the preview.",
                    imageUrl = ""
                )
            )
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product List") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn {
                items(products) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            // Add AsyncImage to display the product image
                            AsyncImage(
                                model = product.imageUrl,
                                contentDescription = product.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(bottom = 8.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(text = "Name: ${product.name}")
                            Text(text = "Price: ${product.price}")
                            Text(text = "Description: ${product.description}")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductListPreview() {
    ProductListScreen(rememberNavController())
}
