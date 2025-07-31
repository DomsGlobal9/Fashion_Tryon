package com.example.dvyb.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import android.widget.Toast
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image


import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen() {
    val tabTitles = listOf("General", "Pricing", "Upload")
    var selectedTabIndex by remember { mutableStateOf(0) }

    val productTypes = listOf("Ready to Wear", "Unstitched")
    var selectedProductType by remember { mutableStateOf(productTypes[0]) }

    val dressTypes = listOf("Kurti", "Gown", "Frock")
    val materialTypes = listOf("Cotton", "Lawn", "Silk")
    val designTypes = listOf("Floral", "Geometric", "Plain")

    var selectedDress by remember { mutableStateOf("") }
    var selectedMaterial by remember { mutableStateOf("") }
    var selectedDesign by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {

        // Top App Bar
        TopAppBar(
            title = { Text("Add New Product", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = { /* Navigate Back */ }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
        )

        // Tabs
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == index) Color(0xFF61A9C6) else Color.Black
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        when (selectedTabIndex) {
            0 -> {
                // General Form Section
                Text("Product Information", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))

                DropdownField(
                    label = "Choose Type",
                    options = listOf("Men", "Women", "Kids"),
                    selected = selectedDress,
                    onValueChange = { selectedDress = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Product Type", fontWeight = FontWeight.Medium)

                Row(modifier = Modifier.padding(vertical = 8.dp)) {
                    productTypes.forEach { type ->
                        val isSelected = selectedProductType == type
                        Button(
                            onClick = { selectedProductType = type },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSelected) Color(0xFF61A9C6) else Color(0xFFF0F0F0)
                            ),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .height(36.dp)
                        ) {
                            Text(
                                text = type,
                                color = if (isSelected) Color.White else Color.Black
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text("Select Dress", fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(10.dp))
                DropdownField(
                    label = "Select Dress",
                    options = dressTypes,
                    selected = selectedDress,
                    onValueChange = { selectedDress = it }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text("Select Material", fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(10.dp))
                DropdownField(
                    label = "Select Material",
                    options = materialTypes,
                    selected = selectedMaterial,
                    onValueChange = { selectedMaterial = it }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text("Select Design", fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(10.dp))
                DropdownField(
                    label = "Select Design",
                    options = designTypes,
                    selected = selectedDesign,
                    onValueChange = { selectedDesign = it }
                )

                Spacer(modifier = Modifier.height(34.dp))

                Button(
                    onClick = { selectedTabIndex = 1 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF61A9C6)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Next", color = Color.White)
                }
            }

            1 -> {
                // Pricing Section (Placeholder)
                Text("Pricing Information", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Enter Price") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { selectedTabIndex = 2 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF61A9C6)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Next", color = Color.White)
                }
            }

            2 -> {
                UploadSection(
                    onBackClick = { selectedTabIndex = 1 },
                    onNextClick = { /* Submit or navigate */ }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownField(
    label: String,
    options: List<String>,
    selected: String,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { selection ->
                DropdownMenuItem(
                    text = { Text(selection) },
                    onClick = {
                        onValueChange(selection)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun UploadSection(
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val context = LocalContext.current
    var imageUris by remember { mutableStateOf<List<Uri>>(emptyList()) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) { uris: List<Uri> ->
        imageUris = uris
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Text("Upload Photos", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(4.dp))
        Text("Add a photo of your product", color = Color.Gray)

        Spacer(modifier = Modifier.height(21.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                .clickable {
                    imagePickerLauncher.launch("image/*")
                },
            contentAlignment = Alignment.Center
        ) {
            if (imageUris.isNotEmpty()) {
                LazyRow {
                    items(imageUris.size) { index ->
                        Image(
                            painter = rememberAsyncImagePainter(imageUris[index]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            } else {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.CameraAlt, contentDescription = null, tint = Color.Gray)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Add photos", color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(27.dp))

        Text("Capture Instruction’s", style = MaterialTheme.typography.titleSmall,fontWeight = FontWeight.Bold, fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        val instructions = listOf(
            "Click 'Upload Photo' beside the product name.",
            "Include image details in the description.",
            "Set the price before uploading the image.",
            "If multiple images are allowed, specify the number.",
            "Select the right category for your image.",
            "Choose the brand linked to the product image."
        )

        instructions.forEach {
            Row(modifier = Modifier.padding(top = 8.dp) .padding(start = 27.dp)) {
                Text("• ", fontWeight = FontWeight.Bold, )
                Text(it, color = Color.Gray,fontSize = 16.sp,modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(34.dp))
            }
        }

        Text("View", style = MaterialTheme.typography.titleSmall, fontSize = 15.sp, color =  Color(0xFF3AB7FF)
        )
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onBackClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Back")
            }

            Button(
                onClick = {
                    if (imageUris.size >= 5) {
                        onNextClick()
                    } else {
                        Toast.makeText(context, "Please upload at least 5 photos", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3AB7FF))
            ) {
                Text("Next")
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.ArrowForward, contentDescription = null)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AddProductScreenPreview() {
    AddProductScreen()
}



