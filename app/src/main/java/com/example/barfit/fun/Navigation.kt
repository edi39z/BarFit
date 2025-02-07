package com.example.barfit.`fun`

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barfit.screen.HomePage
import com.example.barfit.screen.auth.`fun`.AuthManager
import com.example.barfit.screen.auth.login.LoginPage
import com.example.barfit.screen.auth.register.RegisterPage
import com.example.barfit.screen.auth.signup.SignupPage

@Composable
fun Navigation(modifier: Modifier, authManager: AuthManager) {
    val navController = rememberNavController()
    var startDestination by remember { mutableStateOf("login") }
    var isLoading by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

//    LaunchedEffect(Unit) {
//        if (Firebase.auth.currentUser != null) {
//            val userExists = Firebase.firestore.collection("users")
//                .document(Firebase.auth.currentUser!!.uid).get().await()
//                .exists()
//            if (userExists) {
//                startDestination = "home"
//            } else {
//                startDestination = "register"
//            }
//        } else {
//            startDestination = "login"
//        }
//        delay(500)
//        isLoading = false
//    }

//    Loader(isLoading){
        NavHost(
            navController = navController,
            startDestination =startDestination
        ) {
            composable("login") {
                LoginPage(modifier, navController)
            }
            composable("signup") {
                SignupPage(modifier, navController)
            }
            composable("register") {
                RegisterPage(modifier, navController)
            }
            composable("home") {
               HomePage(navController)
            }
        }

}