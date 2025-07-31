@file:OptIn(androidx.compose.animation.ExperimentalAnimationApi::class)

package com.example.clothingbrandapp.ui.screens

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun UploadProductScreen(
    onProductUploaded: (
        product: String,
        price: String,
        quantity: Int,
        imageUri: Uri?,
        category: String,
        subCategory: String
    ) -> Unit
) {
    var currentStep by remember { mutableStateOf(1) }
    var selectedCategory by remember { mutableStateOf("") }
    var selectedSubCategory by remember { mutableStateOf("") }
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "📦 Upload New Product",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(20.dp))

            AnimatedContent(
                targetState = currentStep,
                transitionSpec = { fadeIn(tween(300)) with fadeOut(tween(200)) },
                label = "steps"
            ) { step ->
                when (step) {
                    1 -> CategorySelectionStep { category ->
                        selectedCategory = category
                        currentStep = 2
                    }

                    2 -> FinalDetailsStep(
                        name = productName,
                        price = productPrice,
                        quantity = productQuantity,
                        subCategory = selectedSubCategory,
                        onNameChange = { productName = it },
                        onPriceChange = { productPrice = it },
                        onQuantityChange = { productQuantity = it },
                        onSubCategoryChange = { selectedSubCategory = it },
                        onSubmit = {
                            if (productName.isBlank() || productPrice.isBlank() || productQuantity.isBlank() || selectedSubCategory.isBlank()) {
                                errorMessage = "❗ Fill all fields to continue"
                            } else {
                                currentStep = 3
                            }
                        }
                    )

                    3 -> UploadImageStep(
                        context = context,
                        imageUri = imageUri,
                        onImageSelected = { uri ->
                            val sizeMB = context.contentResolver.openInputStream(uri)
                                ?.available()?.toDouble()?.div(1024 * 1024) ?: 0.0
                            if (sizeMB <= 10) {
                                imageUri = uri
                            } else {
                                errorMessage = "❌ Image exceeds 10MB limit"
                            }
                        },
                        onUpload = {
                            if (imageUri == null) {
                                errorMessage = "❗ Upload an image to continue"
                            } else {
                                onProductUploaded(
                                    productName,
                                    productPrice,
                                    productQuantity.toIntOrNull() ?: 0,
                                    imageUri,
                                    selectedCategory,
                                    selectedSubCategory
                                )
                            }
                        }
                    )
                }
            }
        }

        LaunchedEffect(errorMessage) {
            errorMessage?.let {
                snackbarHostState.showSnackbar(it)
                errorMessage = null
            }
        }
    }
}

@Composable
fun CategorySelectionStep(onSelect: (String) -> Unit) {
    val categories = listOf("Men", "Women", "Kids", "Infants", "Accessories")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Select Category", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(16.dp))
        categories.forEach { category ->
            Button(
                onClick = { onSelect(category) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(category)
            }
        }
    }
}

@Composable
fun FinalDetailsStep(
    name: String,
    price: String,
    quantity: String,
    subCategory: String,
    onNameChange: (String) -> Unit,
    onPriceChange: (String) -> Unit,
    onQuantityChange: (String) -> Unit,
    onSubCategoryChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Enter Product Details", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Product Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = price,
            onValueChange = onPriceChange,
            label = { Text("Product Price") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = quantity,
            onValueChange = onQuantityChange,
            label = { Text("Quantity") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = subCategory,
            onValueChange = onSubCategoryChange,
            label = { Text("Sub Category") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onSubmit,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("Continue to Upload Image")
        }
    }
}

@Composable
fun UploadImageStep(
    context: Context,
    imageUri: Uri?,
    onImageSelected: (Uri) -> Unit,
    onUpload: () -> Unit
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri -> uri?.let(onImageSelected) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clickable { launcher.launch("image/*") },
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (imageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(context)
                                .data(imageUri)
                                .size(Size.ORIGINAL)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text("📸 Tap to select product image", color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onUpload,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Upload Product")
        }
    }
}
