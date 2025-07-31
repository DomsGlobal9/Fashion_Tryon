package com.example.dvyb.data.model

data class CardDetails(
    val cardNumber: String = "",
    val expiry: String = "",
    val cvv: String = ""
)

enum class PaymentMethod {
    GOOGLE_PAY, PHONEPE, BHIM, PAYTM, COD
}
