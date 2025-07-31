package com.example.dvyb.ui.screens.tryon

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.dvyb.utils.ImageUtils
import com.example.dvyb.ui.components.ImagePicker

@Composable
fun TryOnScreen(viewModel: TryOnViewModel = viewModel()) {
    var modelUri by remember { mutableStateOf<Uri?>(null) }
    var garmentUri by remember { mutableStateOf<Uri?>(null) }
    var pickModel by remember { mutableStateOf(false) }
    var pickGarment by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val status by viewModel.status.collectAsState()
    val outputImages by viewModel.images.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Upload Model Photo")
        Button(onClick = { pickModel = true }) {
            Text("Pick Model Image")
        }
        modelUri?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }

        Spacer(Modifier.height(16.dp))

        Text("Upload Garment Photo")
        Button(onClick = { pickGarment = true }) {
            Text("Pick Garment Image")
        }
        garmentUri?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                val modelBase64 = ImageUtils.uriToBase64(context, modelUri!!)
                val garmentBase64 = ImageUtils.uriToBase64(context, garmentUri!!)
                viewModel.runPrediction(
                    token = "fa-jCmx621bg3ye-0kZFcMHh0PgG3YWC38Pl2zbl",
                    modelImageBase64 = modelBase64,
                    garmentImageBase64 = garmentBase64
                )
            },
            enabled = modelUri != null && garmentUri != null
        ) {
            Text("Generate Try-On")
        }

        Spacer(Modifier.height(16.dp))

        Text("Status: $status")

        if (outputImages.isNotEmpty()) {
            Spacer(Modifier.height(24.dp))
            Text("Try-On Result:")
            outputImages.forEach { url ->
                Image(
                    painter = rememberAsyncImagePainter(url),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(250.dp)
                )
            }
        }
    }

    // Image pickers
    if (pickModel) {
        ImagePicker { uri ->
            modelUri = uri
            pickModel = false
        }
    }
    if (pickGarment) {
        ImagePicker { uri ->
            garmentUri = uri
            pickGarment = false
        }
    }
}
