package com.example.dvyb.data.remote.tryon

data class TryOnRequest(
    val model_name: String = "tryon-v1.6",
    val inputs: Inputs
)

data class Inputs(
    val model_image: String,
    val garment_image: String
)
