package com.example.dvyb.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dvyb.R
import com.example.dvyb.data.model.Dress

class DressViewModel : ViewModel() {
    val dressList = listOf(
        Dress("Dress 1", R.drawable.hoodies),
        Dress("Dress 2", R.drawable.polo),
        Dress("Dress 3", R.drawable.hoodies),
        Dress("Dress 4", R.drawable.polo)
    )

    val selectedDress = mutableStateOf(dressList[0])
}
