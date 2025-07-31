package com.example.dvyb.ui.screens.profile


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dvyb.R
import com.example.dvyb.data.model.UserProfile

class ProfileViewModel : ViewModel() {

    private val _userProfile = mutableStateOf(
        UserProfile(
            name = "Sagar vardhan",
            phone = "9294294299",
            imageRes = R.drawable.profile // Your local drawable image
        )
    )

    val userProfile = _userProfile

    // Add update/edit logic if needed
}
