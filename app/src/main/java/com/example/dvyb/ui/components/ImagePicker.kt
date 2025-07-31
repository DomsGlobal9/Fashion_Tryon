package com.example.dvyb.ui.components
// FILE: ui/components/ImagePicker.kt
//package ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*

@Composable
fun ImagePicker(onImagePicked: (Uri?) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri -> onImagePicked(uri) }

    LaunchedEffect(Unit) {
        launcher.launch("image/*")
    }
}
