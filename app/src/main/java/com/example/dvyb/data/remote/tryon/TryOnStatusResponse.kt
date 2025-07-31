package com.example.dvyb.data.remote.tryon

data class TryOnStatusResponse(
    val id: String,
    val status: String,
    val output: OutputData? = null,
    val error: String? = null
)

data class OutputData(
    val images: List<String>
)
