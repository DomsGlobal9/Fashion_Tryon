//package com.example.dvyb.ui.components
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.slideInVertically
//import androidx.compose.animation.slideOutVertically
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.CheckCircle
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.animation.core.Animatable
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.graphicsLayer // ✅ Fix for graphicsLayer
//import androidx.compose.ui.unit.dp
//
//import androidx.compose.material.icons.filled.CheckCircle
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//
//import androidx.compose.ui.unit.dp
//
//
//@Composable
//fun ProductSuccessToast(
//    title: String,
//    description: String,
//    modifier: Modifier = Modifier
//) {
//    val enterAnimation = remember { Animatable(initialValue = 0f) }
//
//    LaunchedEffect(Unit) {
//        enterAnimation.animateTo(
//            targetValue = 1f,
//            animationSpec = tween(durationMillis = 500)
//        )
//    }
//
//    Box(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth(0.9f)
//                .graphicsLayer {
//                    alpha = enterAnimation.value
//                    translationY = (1f - enterAnimation.value) * 50f
//                },
//            shape = RoundedCornerShape(12.dp),
//            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
//            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth()
//            ) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        imageVector = Icons.Default.CheckCircle,
//                        contentDescription = "Success",
//                        tint = Color(0xFF4CAF50),
//                        modifier = Modifier.size(32.dp)
//                    )
//                    Spacer(modifier = Modifier.width(12.dp))
//                    Column {
//                        Text(
//                            text = title,
//                            style = MaterialTheme.typography.titleMedium,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.White
//                        )
//                        Text(
//                            text = description,
//                            style = MaterialTheme.typography.bodyMedium,
//                            color = Color.LightGray
//                        )
//                    }
//                }
//
//                // Green bottom border
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(4.dp)
//                        .padding(top = 16.dp)
//                        .background(Color(0xFF4CAF50))
//                )
//            }
//        }
//    }
//}
