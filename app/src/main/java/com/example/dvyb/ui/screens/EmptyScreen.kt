//package com.example.dvyb.ui.screens
//
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.dvyb.ui.viewmodel.ProductViewModel
//import com.example.dvyb.ui.components.EmptyState
//import com.example.dvyb.R
//
//
//@Composable
//fun EmptyScreen(viewModel: ProductViewModel = viewModel()) {
//    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            EmptyState(
//                title = "Your Products",
//                subtitle = "Looks like you don't have any products yet!",
//                imageRes = R.drawable.empty_box,
//                buttonText = "Add Product",
//                onButtonClick = { /* navigate */ }
//            )
//        }
//    }
//}
