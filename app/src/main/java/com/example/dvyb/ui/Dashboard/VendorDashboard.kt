//package com.example.dvyb.ui.Dashboard
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.dvyb.R
//import com.example.dvyb.ui.components.InfoCard
//
//@Composable
//fun VendorDashboardScreen() {
//    val selectedTab = remember { mutableStateOf("Monthly") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(horizontal = 16.dp)
//            .verticalScroll(rememberScrollState())
//    ) {
//
//        // Header
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.ic_menu),
//                contentDescription = "Menu"
//            )
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Icon(
//                    painter = painterResource(id = R.drawable.logo),
//                    contentDescription = "Logo"
//                )
//                Spacer(modifier = Modifier.width(4.dp))
//                Text("DVYB – Vendor", style = MaterialTheme.typography.titleMedium)
//            }
//            Column(horizontalAlignment = Alignment.End) {
//                Text("12/07/2025", style = MaterialTheme.typography.labelSmall)
//                Text("Friday", style = MaterialTheme.typography.labelSmall)
//            }
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text("Welcome, Vendor!", style = MaterialTheme.typography.titleLarge, color = Color(0xFF163C56))
//        Text("Explore your shop", style = MaterialTheme.typography.bodyMedium)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Image(
//            painter = painterResource(id = R.drawable.saree_sample),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .clip(RoundedCornerShape(12.dp)),
//            contentScale = ContentScale.Crop
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Shop Stats Grid
//        Text("Your Shop", style = MaterialTheme.typography.titleMedium)
//        Spacer(modifier = Modifier.height(12.dp))
//
//        Column {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                InfoCard("Products", "120", R.drawable.ic_products)
//                InfoCard("Inventory", "2,345", R.drawable.ic_inventory)
//            }
//            Spacer(modifier = Modifier.height(12.dp))
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                InfoCard("Total Revenue", "₹ 12000", R.drawable.ic_revenue)
//                InfoCard("Total Units Sold", "1300", R.drawable.ic_units)
//            }
//        }
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Performance Section
//        Text("Performance", style = MaterialTheme.typography.titleMedium)
//        Text("Sales Statistics\nUpdated: Jan 26, 2024, 10 AM", style = MaterialTheme.typography.labelSmall)
//        Spacer(modifier = Modifier.height(12.dp))
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(10.dp))
//                .background(Color(0xFFE8E8E8))
//        ) {
//            listOf("Daily", "Weekly", "Monthly").forEach { label ->
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .clickable { selectedTab.value = label }
//                        .background(
//                            if (selectedTab.value == label) Color(0xFF51AFA0) else Color.Transparent
//                        )
//                        .padding(vertical = 8.dp),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        label,
//                        color = if (selectedTab.value == label) Color.White else Color.Black
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text("High: DEC – ₹0", style = MaterialTheme.typography.labelSmall)
//            Text("Low: JUN – ₹0", style = MaterialTheme.typography.labelSmall)
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        val months = listOf("May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan")
//        val heights = listOf(60, 20, 60, 40, 60, 60, 20, 100, 60)
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            months.forEachIndexed { index, month ->
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    Box(
//                        modifier = Modifier
//                            .width(16.dp)
//                            .height(heights[index].dp)
//                            .clip(RoundedCornerShape(4.dp))
//                            .background(
//                                if (month == "Dec") Color(0xFF163C56)
//                                else Color(0xFFB8E6E1)
//                            )
//                    )
//                    Text(month, style = MaterialTheme.typography.labelSmall)
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(30.dp))
//    }
//
//    // Bottom Navigation
//    NavigationBar(
//        containerColor = Color.White,
//        contentColor = Color.Black
//    ) {
//        val items = listOf(
//            Triple("Dashboard", R.drawable.ic_dashboard, true),
//            Triple("Products", R.drawable.ic_products, false),
//            Triple("Orders", R.drawable.ic_orders, false),
//            Triple("Profile", R.drawable.ic_profile, false)
//        )
//
//        items.forEach { (label, icon, selected) ->
//            NavigationBarItem(
//                icon = {
//                    Icon(painter = painterResource(id = icon), contentDescription = label)
//                },
//                label = { Text(label) },
//                selected = selected,
//                onClick = {}
//            )
//        }
//    }
//}


package com.example.dvyb.ui.Dashboard

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.dvyb.R

@Composable
fun VendorHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        TopBarHeader()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Welcome, Vendor!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF87CEEB)
        )

        Text(
            text = "Explore your shop",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.saree_sample),
            contentDescription = "Shop Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Your Shop",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Stat Cards Grid
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard("Products", "120", R.drawable.ic_products, Modifier.weight(1f))
                StatCard("Inventory", "2,345", R.drawable.ic_inventory, Modifier.weight(1f))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard("Total Revenue", "₹ 12,000", R.drawable.ic_revenue, Modifier.weight(1f))
                StatCard("Units Sold", "1,300", R.drawable.ic_units, Modifier.weight(1f))
            }
        }

        // Sales Chart Section
        SalesPerformanceSection()
    }
}

@Composable
fun StatCard(title: String, value: String, iconResId: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = title,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 12.dp)
            )
            Column {
                Text(text = title, color = Color.Gray, fontSize = 14.sp)
                Text(
                    text = value,
                    color = Color(0xFF4E0021),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun SalesPerformanceSection() {
    var selectedTab by remember { mutableStateOf("Monthly") }

    val months = listOf("May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan")
    val heights = listOf(60, 20, 60, 40, 60, 60, 20, 100, 60)

    Spacer(modifier = Modifier.height(32.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text("Performance", style = MaterialTheme.typography.titleMedium)
        Text("Sales Statistics", color = Color.Gray, fontSize = 14.sp)
        Text("Updated: Jan 26, 2024, 10 AM", fontSize = 12.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFE8E8E8))
        ) {
            listOf("Daily", "Weekly", "Monthly").forEach { label ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = label }
                        .background(if (selectedTab == label) Color(0xFF51AFA0) else Color.Transparent)
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        label,
                        color = if (selectedTab == label) Color.White else Color.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("High: DEC – ₹0", style = MaterialTheme.typography.labelSmall)
            Text("Low: JUN – ₹0", style = MaterialTheme.typography.labelSmall)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp), // Give room for bars to grow bottom-up
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom // ✅ bars grow bottom to top
        ) {
            months.forEachIndexed { index, month ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Box(
                        modifier = Modifier
                            .width(16.dp)
                            .height(heights[index].dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(
                                if (month == "Dec") Color(0xFF163C56)
                                else Color(0xFFB8E6E1)
                            )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(month, style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}

@Composable
fun TopBarHeader() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        color = Color(0xFFF9F9F9),
        shadowElevation = 4.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp)
                    .size(24.dp),
                tint = Color.Black
            )

            Text(
                text = "DVYB – Vendor",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}
