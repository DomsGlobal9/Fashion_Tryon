//package com.example.dvyb.ui.screens
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.dvyb.ui.components.ProductSuccessToast
//import com.example.dvyb.ui.viewmodel.ToastViewModel
//
//@Composable
//fun DashboardScreen(viewModel: ToastViewModel = viewModel()) {
//    Box(modifier = Modifier.fillMaxSize()) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Button(onClick = { viewModel.showSuccessToast() }) {
//                Text("Add Product")
//            }
//        }
//
//        if (viewModel.showToast.value) {
//            ProductSuccessToast(
//                title = "Product Added!",
//                description = "The product was successfully added."
//            )
//        }
//    }
//}
