package com.example.firstapp.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text="REGISTER",
            fontSize = 54.sp,
            color = Color.Magenta,
            fontFamily = FontFamily.Cursive ,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "don't have an account register here",
            fontSize = 24.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(20.dp))

        var fullname by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmpassword by remember { mutableStateOf("") }

        OutlinedTextField(
            value= fullname,
            onValueChange = { fullname = it },
            label={ Text("fullname") },
            singleLine=true,
            leadingIcon={
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "person icon"
                )
            },
            modifier= Modifier.fillMaxWidth()
        )
        Spacer(modifier= Modifier.height(24.dp))

        OutlinedTextField(
            value= email,
            onValueChange = { email = it },
            label={ Text("email") },
            singleLine=true,
            leadingIcon={
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "email icon"
                )
            },
            modifier= Modifier.fillMaxWidth()
        )
        Spacer(modifier= Modifier.height(24.dp))

        OutlinedTextField(
            value= password,
            onValueChange = { password = it },
            label={ Text("password") },
            singleLine=true,
            leadingIcon={
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "password icon"
                )
            },
            modifier= Modifier.fillMaxWidth(),
            visualTransformation= PasswordVisualTransformation()
        )
        Spacer(modifier= Modifier.height(24.dp))

        OutlinedTextField(
            value= confirmpassword,
            onValueChange = { confirmpassword = it },
            label={ Text("confirmpassword") },
            singleLine=true,
            leadingIcon={
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "confirmpassword icon"
                )
            },
            modifier= Modifier.fillMaxWidth(),
            visualTransformation= PasswordVisualTransformation()
        )
        Spacer(modifier= Modifier.height(24.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "REGISTER"
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text="Already have an account"
        )
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text(text="LOGIN", color = Color.White)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun registerscreenpreview() {
    RegisterScreen()
}