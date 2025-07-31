package com.example.clothingbrandapp.ui.screens

import android.net.Uri
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // State to hold uploaded product details
    var uploadedProduct by remember { mutableStateOf("") }
    var uploadedPrice by remember { mutableStateOf("") }
    var uploadedQuantity by remember { mutableStateOf(0) }
    var uploadedImage by remember { mutableStateOf<Uri?>(null) }
    var uploadedCategory by remember { mutableStateOf("") }
    var uploadedSubCategory by remember { mutableStateOf("") }

    NavHost(navController = navController, startDestination = "signup") {

        composable("signup") {
            SignUpScreen(navController = navController)
        }

        composable("kyc") {
            KycScreen(
                onSubmitKYC = {
                    navController.navigate("kycSuccess")
                }
            )
        }

        composable("kycSuccess") {
            KycSuccessScreen(
                onContinue = {
                    navController.navigate("uploadProduct")
                }
            )
        }

        composable("uploadProduct") {
            UploadProductScreen(
                onProductUploaded = { product, price, quantity, imageUri, category, subCategory ->
                    // Save to state
                    uploadedProduct = product
                    uploadedPrice = price
                    uploadedQuantity = quantity
                    uploadedImage = imageUri
                    uploadedCategory = category
                    uploadedSubCategory = subCategory

                    navController.navigate("dashboard")
                }
            )
        }

        composable("dashboard") {
            AdminDashboardScreen(
                uploadedProduct = uploadedProduct,
                uploadedPrice = uploadedPrice,
                uploadedQuantity = uploadedQuantity,
                uploadedImage = uploadedImage,
                uploadedCategory = uploadedCategory,
                uploadedSubCategory = uploadedSubCategory,
                onBackToUpload = {
                    navController.navigate("uploadProduct")
                }
            )
        }
    }
}
