//package com.example.clothingbrandapp
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import com.example.clothingbrandapp.ui.screens.HomePageScreen
//import com.example.clothingbrandapp.ui.theme.ClothingBrandAppTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ClothingBrandAppTheme(
//                darkTheme = false // 👈 Force light theme if needed
//            ) {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color.White // 👈 Ensures white background
//                ) {
//                    HomePageScreen()
//                }
//               }
//        }
//    }
//}


package com.example.clothingbrandapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.clothingbrandapp.ui.screens.MainScreen
import com.example.clothingbrandapp.ui.theme.ClothingBrandAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClothingBrandAppTheme {
                MainScreen() // handles navigation between SignUp, KYC, Dashboard
            }
        }
    }
}

