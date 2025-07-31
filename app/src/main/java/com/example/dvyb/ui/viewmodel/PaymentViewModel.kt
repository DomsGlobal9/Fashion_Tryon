package com.example.dvyb.ui.viewmodel


import androidx.lifecycle.ViewModel
import com.example.dvyb.data.model.CardDetails
import com.example.dvyb.data.model.PaymentMethod
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PaymentViewModel : ViewModel() {
    private val _selectedMethod = MutableStateFlow(PaymentMethod.GOOGLE_PAY)
    val selectedMethod: StateFlow<PaymentMethod> = _selectedMethod

    private val _cardDetails = MutableStateFlow(CardDetails())
    val cardDetails: StateFlow<CardDetails> = _cardDetails

    fun selectMethod(method: PaymentMethod) {
        _selectedMethod.value = method
    }

    fun updateCardNumber(value: String) {
        _cardDetails.value = _cardDetails.value.copy(cardNumber = value)
    }

    fun updateExpiry(value: String) {
        _cardDetails.value = _cardDetails.value.copy(expiry = value)
    }

    fun updateCVV(value: String) {
        _cardDetails.value = _cardDetails.value.copy(cvv = value)
    }
}
