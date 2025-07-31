////package com.example.dvyb
////
////import android.os.Bundle
////import androidx.activity.ComponentActivity
////import androidx.activity.compose.setContent
////import androidx.activity.enableEdgeToEdge
////import androidx.compose.foundation.layout.fillMaxSize
////import androidx.compose.foundation.layout.padding
////import androidx.compose.material3.Scaffold
////import androidx.compose.material3.Text
////import androidx.compose.runtime.Composable
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.tooling.preview.Preview
////import androidx.navigation.compose.rememberNavController
////import com.example.dvyb.navigation.AppNavigation
////import com.example.dvyb.ui.theme.DVYBTheme
//
////
////class MainActivity : ComponentActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        enableEdgeToEdge()
////        setContent {
////            DVYBTheme  {
////                val navController = rememberNavController()
////                AppNavigation(navController)
////            }
////        }
////    }
////}
////
//
//package com.example.dvyb
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
////import com.example.dvyb.ui.screens.ProductView
////import androidx.navigation.compose.rememberNavController
////import androidx.navigation.compose.NavHost
////import androidx.navigation.compose.composable
////import com.example.dvyb.ui.RegisterScreen
////import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//
////import com.example.dvyb.ui.ShopDetailsScreen
////import com.example.dvyb.screens.RegisterBankDetailsScreen
////import com.example.dvyb.ui.Dashboard.VendorHomeScreen
//////import com.example.dvyb.ui.dashboard.VendorHomeScreen
////import com.example.dvyb.ui.VendorPreferencesScreen
////import com.example.dvyb.ui.Dashboard.TotalRevenueScreen
////import  com.example.dvyb.ui.Dashboard.InventoryScreen
//////import com.example.dvyb.ui.screens.DashboardScreen
////import  com.example.dvyb.ui.screens.profile.ProfileScreen
//import  com.example.dvyb.ui.screens.profile.VendorRegisterScreen
////import  com.example.dvyb.ui.screens.profile.ShopDetailsScreen
//import  com.example.dvyb.ui.screens.profile.PayoutSettingsScreen
//import  com.example.dvyb.ui.screens.profile.ProductView
//import com.example.dvyb.ui.screens.AddProductScreen
////import com.example.dvyb.ui.screens.EmptyScreen
//import com.example.dvyb.ui.screens.PaymentScreen
//import com.example.dvyb.ui.screens.PaymentSuccessScreen
//import com.example.dvyb.ui.screens.DosAndDontsScreen
//import com.example.dvyb.ui.screens.ProductScreens.CategoryScreen
//
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContent {
////            val navController = rememberNavController()
////            NavHost(navController = navController, startDestination = "register") {
////                composable("register") {
////                    RegisterScreen(
////                        onNext = { navController.navigate("shopDetails") }
////                    )
////                }
////                composable("shopDetails") {
////                    ShopDetailsScreen(
////                        onNext = { navController.navigate("bankDetails") }
////                    )
////                }
////
////                composable("bankDetails") {
////                    RegisterBankDetailsScreen(
////                        onNext = { bankDetailsState ->
////                            navController.navigate("vendorPrefs")
////                        },
////                        onHelp = {
////                            // You can show a dialog, toast, etc.
////                        }
////                    )
////                }
////
////                composable("vendorPrefs") {
////                    VendorPreferencesScreen()
////                }
////            }
////        }
//
//        setContent{
////            VendorHomeScreen()
//
//            AddProductScreen()
////            InventoryScreen()
//            //TotalRevenueScreen()
//
//
////            DashboardScreen()
//
////            VendorDashboardScreen()
//
//
//
//            //profile section
//
////            ProfileScreen()
////            VendorRegisterScreen()
////            ShopDetailsScreen()
////            PayoutSettingsScreen()
//
////            ProductView()
//
//
//
////            EmptyScreen()
//
////            imp
////            AddProductScreen()
//
////            DosAndDontsScreen()
//
////            PaymentScreen()
//
////            PaymentSuccessScreen()
////            CategoryScreen()
//
////            NavHost(navController = navController, startDestination = "register") {
////                composable("register") {
////                    RegisterScreen(
////                        onNext = { navController.navigate("shopDetails") }
////                    )
////                }
////                }
//
//
//        }
//    }
//}




//dummy
//
//package com.example.dvyb
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.runtime.Composable
////import com.example.dvyb.ui.screens.profile.
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.dvyb.ui.screens.profile.RegisterScreen
//import com.example.dvyb.ui.screens.profile.RegisterBankDetailsScreen
////VendorPreferencesScreen
////ShopDetailsScreen
////import com.example.dvyb.ui.screens.profile.RegisterBankDetailsScreen
////import com.example.dvyb.ui.screens.profile.VendorPreferencesScreen
//import com.example.dvyb.ui.theme.DVYBTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContent {
//            DVYBTheme {
//                val navController = rememberNavController()
//
//                NavHost(navController = navController, startDestination = "register") {
//                    composable("register") {
//                        RegisterScreen(
//                            onNext = { navController.navigate("shopDetails") }
//                        )
//                    }
//                }
//
//
////                    composable("shopDetails") {
////                        ShopDetailsScreen(
////                            onNext = { navController.navigate("bankDetails") }
////                        )
////                    }
////                    composable("bankDetails") {
////                        RegisterBankDetailsScreen(
////                            onNext = { navController.navigate("vendorPrefs") },
////                            onHelp = { /* Show help dialog or toast */ }
////                        )
////                    }
////                    composable("vendorPrefs") {
////                        VendorPreferencesScreen()
////                    }
////                }
//            }
//        }
//    }
//}




//pura dummy
//
// FILE: MainActivity.kt
//
package com.example.dvyb

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import coil.compose.rememberImagePainter
//import com.example.dvyb.ui.theme.TryOnAppTheme
import androidx.activity.compose.setContent
import  com.example.dvyb.ui.screens.tryon.TryOnViewModel
import  com.example.dvyb.ui.screens.tryon.TryOnScreen
import com.example.dvyb.data.remote.tryon.Inputs
import com.example.dvyb.data.remote.tryon.TryOnRequest
import com.example.dvyb.data.remote.tryon.TryOnApiService
import com.example.dvyb.utils.ImageUtils
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.fashn.ai/v1/run/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val tryOnApiService = retrofit.create(TryOnApiService::class.java)

        val viewModelFactory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(TryOnViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return TryOnViewModel(tryOnApiService) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }

        val viewModel: TryOnViewModel by viewModels { viewModelFactory }

        setContent {
            TryOnScreen(viewModel)
        }
    }
}
