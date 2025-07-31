package com.example.dvyb.data.remote.tryon

data class TryOnResponse(
    val id: String,
    val output: Output?
)

data class Output(
    val images: List<String>
)
