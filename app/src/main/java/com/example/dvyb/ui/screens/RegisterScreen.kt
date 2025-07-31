//package com.example.dvyb.ui
//
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowDropDown
//import androidx.compose.material.icons.filled.Help
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.dvyb.R
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.TextField
//
//@Composable
//    fun RegisterScreen(onNext: () -> Unit) {
//    val context = LocalContext.current
//
//
//    var name by remember { mutableStateOf("") }
//    var phone by remember { mutableStateOf("") }
//    var state by remember { mutableStateOf("") }
//    var city by remember { mutableStateOf("") }
//    var address by remember { mutableStateOf("") }
//
//    var expanded by remember { mutableStateOf(false) }
//    val stateList = listOf("Andhra Pradesh", "Karnataka", "Tamil Nadu", "Telangana", "Kerala")
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(24.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        // Logo
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = "Logo",
//            modifier = Modifier
//                .size(80.dp)
//                .padding(top = 32.dp)
//        )
//
//        Text(
//            text = "Register",
//            fontSize = 22.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(top = 36.dp)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Step Indicator
//        Row(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier.fillMaxWidth(0.7f)
//        ) {
//            Box(
//                modifier = Modifier
//                    .height(3.dp)
//                    .weight(1f)
//                    .background(Color(0xFF008CBD))
//            )
//            Spacer(modifier = Modifier.width(4.dp))
//            Box(
//                modifier = Modifier
//                    .height(3.dp)
//                    .weight(1f)
//                    .background(Color.LightGray)
//            )
//            Spacer(modifier = Modifier.width(4.dp))
//            Box(
//                modifier = Modifier
//                    .height(3.dp)
//                    .weight(1f)
//                    .background(Color.LightGray)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "1  Personal details",
//            color = Color(0xFF008CBD),
//            fontWeight = FontWeight.Bold,
//            fontSize = 14.sp,
//            modifier = Modifier.align(Alignment.Start)
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Inputs
//        UnderlinedTextField(value = name, onValueChange = { name = it }, label = "Enter Your Name")
//        Spacer(modifier = Modifier.height(12.dp))
//        UnderlinedTextField(value = phone, onValueChange = { phone = it }, label = "Enter 10 digit mobile number")
//        Spacer(modifier = Modifier.height(12.dp))
//
//        // State Dropdown
//        Box(modifier = Modifier.fillMaxWidth()) {
//            UnderlinedTextField(
//                value = state,
//                onValueChange = { },
//                label = "Select State",
//                readOnly = true,
//                trailingIcon = {
//                    Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
//                },
//                onClick = { expanded = true }
//            )
//
//            DropdownMenu(
//                expanded = expanded,
//                onDismissRequest = { expanded = false }
//            ) {
//                stateList.forEach {
//                    DropdownMenuItem(onClick = {
//                        state = it
//                        expanded = false
//                    }, text = { Text(it) })
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//        UnderlinedTextField(value = city, onValueChange = { city = it }, label = "City")
//        Spacer(modifier = Modifier.height(12.dp))
//        UnderlinedTextField(value = address, onValueChange = { address = it }, label = "Address")
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        // Next Button
//        Button(
//            onClick = {
//                Toast.makeText(context, "Proceeding...", Toast.LENGTH_SHORT).show()
//                onNext() // Navigate to ShopDetails
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008CBD))
//        ) {
//            Text("Next", color = Color.White)
//        }
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Text("Need help?")
//            Icon(
//                imageVector = Icons.Filled.Help,
//                contentDescription = "Help",
//                tint = Color(0xFF008CBD),
//                modifier = Modifier.padding(start = 4.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun UnderlinedTextField(
//    value: String,
//    onValueChange: (String) -> Unit,
//    label: String,
//    readOnly: Boolean = false,
//    trailingIcon: @Composable (() -> Unit)? = null,
//    onClick: (() -> Unit)? = null
//) {
//    TextField(
//        value = value,
//        onValueChange = onValueChange,
//        label = { Text(label) },
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(enabled = readOnly && onClick != null) { onClick?.invoke() },
//        colors = TextFieldDefaults.colors(
//            focusedIndicatorColor = Color(0xFF008CBD),
//            unfocusedIndicatorColor = Color.Gray,
//            disabledIndicatorColor = Color.Transparent,
//            focusedContainerColor = Color.Transparent,
//            unfocusedContainerColor = Color.Transparent,
//            disabledContainerColor = Color.Transparent
//        ),
//        singleLine = true,
//        readOnly = readOnly,
//        trailingIcon = trailingIcon
//    )
//}

package com.example.dvyb.ui.screens.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dvyb.R

@Composable
fun RegisterScreen(onNext: () -> Unit) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val allStates = listOf(
        "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
        "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala",
        "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
        "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
        "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands",
        "Chandigarh", "Dadra and Nagar Haveli and Daman and Diu", "Delhi",
        "Jammu and Kashmir", "Ladakh", "Lakshadweep", "Puducherry"
    )

    val filteredStates = remember(state) {
        if (state.isBlank()) allStates
        else allStates.filter { it.startsWith(state, ignoreCase = true) }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.loginbg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp)
                .padding(top = 32.dp)
        )

        Text(
            text = "Register",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 36.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .weight(1f)
                    .background(Color(0xFF008CBD))
            )
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .weight(1f)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .weight(1f)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .weight(1f)
                    .background(Color.LightGray)
            )
        }

        Spacer(modifier = Modifier.height(34.dp))

        Text(
            text = "1  Personal details",
            color = Color(0xFF008CBD),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        UnderlinedTextField(value = name, onValueChange = { name = it }, label = "Enter Your Name")
        Spacer(modifier = Modifier.height(12.dp))
        UnderlinedTextField(value = phone, onValueChange = { phone = it }, label = "Enter 10 digit mobile number")
        Spacer(modifier = Modifier.height(12.dp))

        // 🔍 Searchable State Dropdown with proper click handling and styling
        Box(modifier = Modifier.fillMaxWidth()) {
            UnderlinedTextField(
                value = state,
                onValueChange = {
                    state = it
                    expanded = true
                },
                label = "State",
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown",
                        modifier = Modifier.clickable { expanded = true }
                    )
                },
                onClick = { expanded = true } // ⬅ allows text field to open dropdown
            )

            DropdownMenu(
                expanded = expanded && filteredStates.isNotEmpty(),
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(0.95f)
            ) {
                filteredStates.forEach {
                    DropdownMenuItem(
                        onClick = {
                            state = it
                            expanded = false
                        },
                        text = {
                            Text(
                                text = it,
                                color = Color.Black,
                                fontSize = 14.sp
                            )
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        UnderlinedTextField(value = city, onValueChange = { city = it }, label = "City")
        Spacer(modifier = Modifier.height(12.dp))
        UnderlinedTextField(value = address, onValueChange = { address = it }, label = "Address")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Proceeding...", Toast.LENGTH_SHORT).show()
                onNext()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008CBD))
        ) {
            Text("Next", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Need help?")
            Icon(
                imageVector = Icons.Filled.Help,
                contentDescription = "Help",
                tint = Color(0xFF008CBD),
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun UnderlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    readOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = label,
                color = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(enabled = readOnly || onClick != null) {
                onClick?.invoke()
            },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color(0xFF0BA4E0),
            unfocusedIndicatorColor = Color.LightGray,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            cursorColor = Color(0xFF0BA4E0),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        singleLine = true,
        readOnly = readOnly,
        trailingIcon = trailingIcon
    )
}

