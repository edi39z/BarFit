package com.example.barfit.views.activity

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.barfit.views.AuthState
import com.example.barfit.views.AuthViewModel

@Composable
fun LoginPage(modifier : Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel){

    var email by remember {
        mutableStateOf("") }
    var password by remember {
        mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Login Page", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(16.dp))
            //email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") }
            )
        Spacer(modifier = Modifier.height(8.dp))
            //password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Password") }
            )
        Spacer(modifier = Modifier.height(16.dp))
        //button
        Button(onClick = {authViewModel.login(email, password)},
            enabled = authState.value != AuthState.Loading
            ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(14.dp))

        //Tidak punya akun?
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Don't have an account?")
            TextButton(onClick = { navController.navigate("signup") }, contentPadding = PaddingValues(0.dp)) {
                Text(text = "Sign up", fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        //Login dengan Third Party
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(modifier = Modifier.weight(1f))
            Text(
                text = " or Continue with ",
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Color.Gray
            )
            Divider(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            TextButton(onClick = { /* Google */ }) {
                Text(text = "Google", color = Color.Gray)
            }
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(onClick = { /* Facebook */ }) {
                Text(text = "Facebook", color = Color.Gray)
            }
        }




    }


}