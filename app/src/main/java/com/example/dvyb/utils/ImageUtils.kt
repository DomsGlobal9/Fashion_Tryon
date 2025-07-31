package com.example.dvyb.utils

// FILE: utils/ImageUtils.kt

import android.content.Context
import android.net.Uri
import android.util.Base64
import java.io.InputStream

object ImageUtils {
    fun uriToBase64(context: Context, uri: Uri): String {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val bytes = inputStream?.readBytes() ?: return ""
        return Base64.encodeToString(bytes, Base64.NO_WRAP)
    }
}
