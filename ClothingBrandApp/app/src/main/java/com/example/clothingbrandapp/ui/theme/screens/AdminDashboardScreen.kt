package com.example.clothingbrandapp.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import java.text.SimpleDateFormat
import java.util.*

data class Order(
    val productName: String,
    val price: Double,
    val quantity: Int,
    val buyerName: String,
    val location: String,
    val address: String,
    val dateTime: String,
    val imageUri: Uri?
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboardScreen(
    uploadedProduct: String,
    uploadedPrice: String,
    uploadedQuantity: Int,
    uploadedImage: Uri?,
    uploadedCategory: String,
    uploadedSubCategory: String,
    onBackToUpload: () -> Unit
) {
    val adminName = "Admin"
    val unitPrice = uploadedPrice.toDoubleOrNull() ?: 0.0
    val now = getCurrentDateTime()

    val sampleAddresses = listOf(
        "#123 5th Cross, Bangalore",
        "Flat 4B, Green Heights, Mumbai",
        "32, Rose Street, Delhi"
    )

    val orders = remember(uploadedProduct, uploadedPrice, uploadedImage) {
        mutableStateListOf(
            Order(
                productName = uploadedProduct,
                price = unitPrice,
                quantity = uploadedQuantity,
                buyerName = "Ravi",
                location = "Bangalore",
                address = sampleAddresses[0],
                dateTime = now,
                imageUri = uploadedImage
            ),
            Order(
                productName = "$uploadedProduct Combo",
                price = unitPrice,
                quantity = uploadedQuantity + 1,
                buyerName = "Sneha",
                location = "Mumbai",
                address = sampleAddresses[1],
                dateTime = now,
                imageUri = null
            ),
            Order(
                productName = "Premium $uploadedProduct",
                price = unitPrice,
                quantity = uploadedQuantity + 2,
                buyerName = "Amit",
                location = "Delhi",
                address = sampleAddresses[2],
                dateTime = now,
                imageUri = uploadedImage
            )
        )
    }

    val totalOrders = orders.sumOf { it.quantity }
    val totalSales = orders.sumOf { it.quantity * it.price }
    val revenue = totalSales * 1.20
    val profit = revenue - totalSales
    val orderCancelled = 0
    val pendingOrders = 1

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Welcome back, $adminName!", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                },
                actions = {
                    TextButton(onClick = onBackToUpload) {
                        Text("➕ New Upload")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            StatGrid(
                completed = totalOrders,
                pending = pendingOrders,
                cancelled = orderCancelled,
                revenue = revenue
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text("Order Stats", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            orders.forEach { order ->
                OrderCard(order)
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Progress Summary", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))

            LinearProgressIndicator(
                progress = (totalOrders.coerceAtMost(10)) / 10f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                color = Color(0xFF4F46E5)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text("Order Goal: $totalOrders/10", fontSize = 13.sp, color = Color.Gray)
        }
    }
}

@Composable
fun StatGrid(completed: Int, pending: Int, cancelled: Int, revenue: Double) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            DashboardStat("Orders Completed", "$completed", Color(0xFFE8F8EE), Color(0xFF22C55E), "✅")
            DashboardStat("Orders Pending", "$pending", Color(0xFFE0F4FF), Color(0xFF38BDF8), "⏳")
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            DashboardStat("Orders Cancelled", "$cancelled", Color(0xFFFFE5E5), Color(0xFFF43F5E), "❌")
            DashboardStat("Revenue (w/ 20%)", "₹${String.format("%.2f", revenue)}", Color(0xFFFFF3E0), Color(0xFFFF9800), "💰")
        }
    }
}

@Composable
fun DashboardStat(
    title: String,
    value: String,
    bgColor: Color,
    iconColor: Color,
    icon: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = bgColor),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.height(90.dp)
    ) {
        Row(
            Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(iconColor),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, fontSize = 18.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(title, fontSize = 13.sp, color = Color.Gray)
                Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun OrderCard(order: Order) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (order.imageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(order.imageUri),
                        contentDescription = null,
                        modifier = Modifier
                            .size(55.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(order.productName, fontWeight = FontWeight.Medium)
                    Text("Qty: ${order.quantity}", fontSize = 13.sp, color = Color.DarkGray)
                    Text(order.address, fontSize = 12.sp, color = Color.Gray)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("₹${String.format("%.2f", order.price * order.quantity)}", fontWeight = FontWeight.Medium)
                    Text("Paid", fontSize = 12.sp, color = Color(0xFF16A34A))
                    Text(order.dateTime, fontSize = 11.sp, color = Color.Gray)
                }
            }
        }
    }
}

fun getCurrentDateTime(): String {
    val sdf = SimpleDateFormat("dd/MM/yy HH:mm", Locale.getDefault())
    return sdf.format(Date())
}
