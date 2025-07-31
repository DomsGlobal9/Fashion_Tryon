package com.example.dvyb.data.model


data class PayoutState(
    val bankName: String = "",
    val bankAddress: String = "",
    val accountHolderName: String = "",
    val bankAccountNumber: String = "",
    val ifscCode: String = "",
    val upiId: String = ""
)
