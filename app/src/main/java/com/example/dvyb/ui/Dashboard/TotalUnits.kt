//
//package com.example.dvyb.ui.dashboard
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.revenueui.ui.theme.RevenueUITheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
////            RevenueUITheme {
////                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//            RevenueDashboard()
//        //}
//          //  }
//        }
//    }
//}
//
//@Composable
//fun RevenueDashboard() {
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(16.dp)) {
//
//        // Top Bar
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
//            Spacer(modifier = Modifier.width(8.dp))
//            Text("Total Revenue", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Revenue Summary
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//            SummaryCard(title = "Total Revenue", value = "₹0", highlighted = true)
//            SummaryCard(title = "Total Refunds", value = "0")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Dropdowns
////        DropdownField(label = "Select city")
////        Spacer(modifier = Modifier.height(8.dp))
////        DropdownField(label = "Select Product")
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Revenue Analysis Section
//        Text("Revenue Analysis", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
//        Text("₹0", fontWeight = FontWeight.Bold, fontSize = 24.sp)
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Toggle Tabs
//        val selectedTab = remember { mutableStateOf("Monthly") }
//        Row {
//            listOf("Daily", "Weekly", "Monthly").forEach {
//                FilterChip(text = it, selected = selectedTab.value == it) {
//                    selectedTab.value = it
//                }
//                Spacer(modifier = Modifier.width(8.dp))
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        Text("High: DEC – ₹0", fontSize = 12.sp)
//        Text("Low: JUN – ₹0", fontSize = 12.sp)
//
//        Spacer(modifier = Modifier.height(16.dp))
//        RevenueBarChart()
//
//        Spacer(modifier = Modifier.height(16.dp))
////        RevenueByProductList()
//    }
//}
//
//@Composable
//fun SummaryCard(title: String, value: String, highlighted: Boolean = false) {
//    Card(
//        colors = if (highlighted) CardDefaults.cardColors(containerColor = Color(0xFFDBEEF2)) else CardDefaults.cardColors(),
//        modifier = Modifier
////            .weight(1f)
//            .padding(end = if (highlighted) 8.dp else 0.dp)
//            .height(80.dp),
//        shape = RoundedCornerShape(10.dp)
//    ) {
//        Column(
//            Modifier
//                .fillMaxSize()
//                .padding(12.dp),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(title, fontSize = 14.sp, fontWeight = FontWeight.Medium)
//            Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
//        }
//    }
//}
//
////@Composable
////fun DropdownField(label: String) {
////    var expanded by remember { mutableStateOf(false) }
////    var selectedOption by remember { mutableStateOf("") }
////
////    ExposedDropdownMenuBox(
////        expanded = expanded,
////        onExpandedChange = { expanded = !expanded },
////    ) {
////        TextField(
////            value = selectedOption,
////            onValueChange = { selectedOption = it },
////            readOnly = true,
////            label = { Text(label) },
////            trailingIcon = {
////                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
////            },
////            modifier = Modifier.menuAnchor().fillMaxWidth()
////        )
////        ExposedDropdownMenu(
////            expanded = expanded,
////            onDismissRequest = { expanded = false }
////        ) {
////            listOf("Option 1", "Option 2").forEach { item ->
////                DropdownMenuItem(
////                    text = { Text(item) },
////                    onClick = {
////                        selectedOption = item
////                        expanded = false
////                    }
////                )
////            }
////        }
////    }
////}
//
//@Composable
//fun FilterChip(text: String, selected: Boolean, onClick: () -> Unit) {
//    Button(
//        onClick = onClick,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = if (selected) Color(0xFFDBEEF2) else Color.White,
//            contentColor = if (selected) Color.Black else Color.Gray
//        ),
//        shape = RoundedCornerShape(8.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
//        elevation = ButtonDefaults.buttonElevation(2.dp)
//    ) {
//        Text(text)
//    }
//}
//
//@Composable
//fun RevenueBarChart() {
//    val months = listOf("May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan")
//    val values = listOf(0f, 1f, 2f, 1.5f, 2.5f, 1f, 1.7f, 3f, 1.2f)
//    val maxVal = values.maxOrNull() ?: 1f
//
//    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//        months.zip(values).forEach { (month, value) ->
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Box(
//                    modifier = Modifier
//                        .width(20.dp)
//                        .height((value / maxVal * 100).dp)
//                        .background(
//                            color = if (value == maxVal) Color.Black else Color(0xFFDBEEF2),
//                            shape = RoundedCornerShape(4.dp)
//                        )
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(month, fontSize = 12.sp)
//            }
//        }
//    }
//}
////
////@Composable
////fun RevenueByProductList() {
////    val products = listOf(
////        Triple("Trendy Red Lehenga", "₹5,000", R.drawable.red_lehenga),
////        Triple("Cotton saree", "₹4,000", R.drawable.cotton_saree),
////        Triple("Kids Bottom", "₹3,345.67", R.drawable.kids_bottom),
////    )
////
////    Column(modifier = Modifier.fillMaxWidth()) {
////        Text("Revenue by Product", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
////        Spacer(modifier = Modifier.height(8.dp))
////
////        LazyColumn {
////            items(products) { (title, price, imageRes) ->
////                Row(
////                    Modifier
////                        .fillMaxWidth()
////                        .padding(vertical = 8.dp),
////                    verticalAlignment = Alignment.CenterVertically
////                ) {
////                    Image(
////                        painter = painterResource(id = imageRes),
////                        contentDescription = null,
////                        modifier = Modifier
////                            .size(50.dp)
////                            .background(Color.LightGray, CircleShape)
////                    )
////                    Spacer(modifier = Modifier.width(12.dp))
////                    Column {
////                        Text(title, fontWeight = FontWeight.Bold)
////                        Text(price, color = Color.Gray)
////                    }
////                }
////            }
////        }
////    }
////}

package com.example.dvyb.ui.Dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.lazy.item
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ProductionQuantityLimits
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dvyb.R

@Composable
fun TotalRevenueScreen() {
    val selectedTab = remember { mutableStateOf("Monthly") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Top Bar
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.vector1),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Total Units Sold", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            // Summary Cards
            Row(modifier = Modifier.fillMaxWidth()) {
                SummaryCard("Total Revenue", "₹0", highlighted = true, modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                SummaryCard("Total Sales", "0", modifier = Modifier.weight(1f))
            }
        }

        item {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Select city") },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.vector2),
                        contentDescription = null
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Select Product") },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.vector2),
                        contentDescription = null
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

//        item {
//            Text("Revenue Analysis", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
//            Text("₹0", fontWeight = FontWeight.Bold, fontSize = 24.sp)
//        }

        item {
            // Tabs
            Row {
                listOf("Daily", "Weekly", "Monthly").forEach {
                    FilterChip(text = it, selected = selectedTab.value == it) {
                        selectedTab.value = it
                    }
                    Spacer(modifier = Modifier.width(28.dp))
                }
            }
        }

        item {
            Text("High: DEC – ₹0", fontSize = 12.sp)
            Text("Low: JUN – ₹0", fontSize = 12.sp)
        }

        item {
            RevenueBarChart()
        }

//        // ✅ Insert PNG image below graph section
//        item {
//            Image(
//                painter = painterResource(id = R.drawable.vector2), // Replace with your actual PNG file name
//                contentDescription = "Bar Chart Image",
//                contentScale = ContentScale.FillWidth,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 16.dp)
//            )
//        }

        item {
            HighestRevenueProductsSection()
        }
    }
}

@Composable
fun SummaryCard(
    title: String,
    value: String,
    highlighted: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        colors = if (highlighted)
            CardDefaults.cardColors(containerColor = Color(0xFFDBEEF2))
        else CardDefaults.cardColors(),
        modifier = modifier.height(80.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun FilterChip(text: String, selected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color(0xFFDBEEF2) else Color.White,
            contentColor = if (selected) Color.Black else Color.Gray
        ),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
        elevation = ButtonDefaults.buttonElevation(2.dp)
    ) {
        Text(text)
    }
}

@Composable
fun RevenueBarChart() {
    val months = listOf("May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan")
    val values = listOf(0f, 1f, 2f, 1.5f, 2.5f, 1f, 1.7f, 3f, 1.2f)
    val maxVal = values.maxOrNull() ?: 1f

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        months.zip(values).forEach { (month, value) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(text = value.toInt().toString(), fontSize = 12.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .width(20.dp)
                        .height((value / maxVal * 80).dp)
                        .background(
                            color = if (value == maxVal) Color(0xFF163C56) else Color(0xFFDBEEF2),
                            shape = RoundedCornerShape(4.dp)
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(month, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun HighestRevenueProductsSection() {
    Column {
        Text(
            text = "Highest Revenue Products",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(12.dp))

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            RevenueProductCard(
                index = 1,
                title = "Black floral kurthi",
                price = "₹12,000",
                units = "150",
                imageRes = R.drawable.kurthi
            )
            RevenueProductCard(
                index = 2,
                title = "Pink Polo T-Shirt",
                price = "₹12,000",
                units = "150",
                imageRes = R.drawable.polo
            )
            RevenueProductCard(
                index = 3,
                title = "Pink Polo T-Shirt",
                price = "₹12,000",
                units = "150",
                imageRes = R.drawable.polo
            )

        }
    }
}

@Composable
fun RevenueProductCard(
    index: Int,
    title: String,
    price: String,
    units: String,
    imageRes: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "$index. $title", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.vector2),
                    contentDescription = "Shopping cart",
                    modifier = Modifier
                        .size(24.dp)  // Adjust size as needed
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(price, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.vector2),
                    contentDescription = "Shopping cart",
                    modifier = Modifier
                        .size(24.dp)  // Adjust size as needed
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(units, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /* TODO: Navigate */ },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text("View Product")
                Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }
}
