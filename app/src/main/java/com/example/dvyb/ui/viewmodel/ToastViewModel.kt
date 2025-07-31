package com.example.dvyb.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ToastViewModel : ViewModel() {
    val showToast = mutableStateOf(false)

    fun showSuccessToast() {
        showToast.value = true
        viewModelScope.launch {
            delay(3000) // Auto-dismiss after 3s
            showToast.value = false
        }
    }
}
