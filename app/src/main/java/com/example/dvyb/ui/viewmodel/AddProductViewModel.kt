package com.example.dvyb.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dvyb.data.model.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddProductViewModel : ViewModel() {

    private val _product = MutableStateFlow(ProductModel())
    val product: StateFlow<ProductModel> = _product.asStateFlow()

    fun updateName(value: String) {
        _product.value = _product.value.copy(name = value)
    }

    fun updateDescription(value: String) {
        _product.value = _product.value.copy(description = value)
    }

    fun updateCategory(value: String) {
        _product.value = _product.value.copy(category = value)
    }

    fun updateProductType(value: String) {
        _product.value = _product.value.copy(productType = value)
    }

    fun updateDressType(value: String) {
        _product.value = _product.value.copy(dressType = value)
    }

    fun updateMaterial(value: String) {
        _product.value = _product.value.copy(material = value)
    }

    fun updateDesign(value: String) {
        _product.value = _product.value.copy(design = value)
    }

    fun updateBrand(value: String) {
        _product.value = _product.value.copy(brand = value)
    }

    fun updateStock(value: String) {
        _product.value = _product.value.copy(stock = value)
    }

    fun updateWarranty(value: String) {
        _product.value = _product.value.copy(warranty = value)
    }

    fun updateColor(value: String) {
        _product.value = _product.value.copy(color = value)
    }

    fun updatePrice(value: String) {
        _product.value = _product.value.copy(price = value)
    }

    fun updateImageUrl(value: String) {
        _product.value = _product.value.copy(imageUrl = value)
    }
}

