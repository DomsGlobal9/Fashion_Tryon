//package com.example.dvyb.ui.viewmodel
//
//
//
//import androidx.lifecycle.ViewModel
//import com.example.dvyb.R
//import com.example.dvyb.data.model.Dress
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//
//class UserFormViewModel : ViewModel() {
//
//    private val _dressList = MutableStateFlow<List<Dress>>(listOf(
//        Dress(1, "Dress 1", R.drawable.dress_main),
//        Dress(2, "Dress 1", R.drawable.dress_1),
//        Dress(3, "Dress 1", R.drawable.dress_2),
//        Dress(4, "Dress 1", R.drawable.dress_3),
//        Dress(5, "Dress 1", R.drawable.dress_4),
//    ))
//    val dressList: StateFlow<List<Dress>> = _dressList
//
//    private val _selectedDress = MutableStateFlow(_dressList.value[0])
//    val selectedDress: StateFlow<Dress> = _selectedDress
//
//    fun onSelectDress(dress: Dress) {
//        _selectedDress.value = dress
//    }
//}


