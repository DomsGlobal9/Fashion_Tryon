package com.example.dvyb.ui.screens.tryon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dvyb.data.remote.tryon.Inputs
import com.example.dvyb.data.remote.tryon.RetrofitInstance
import com.example.dvyb.data.remote.tryon.TryOnApiService
import com.example.dvyb.data.remote.tryon.TryOnRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.dvyb.data.remote.tryon.TryOnResponse

import kotlinx.coroutines.launch

class TryOnViewModel(
    private val apiService: TryOnApiService = RetrofitInstance.api
) : ViewModel() {

    private val _status = MutableStateFlow("Idle")
    val status: StateFlow<String> = _status.asStateFlow()

    private val _images = MutableStateFlow<List<String>>(emptyList())
    val images: StateFlow<List<String>> = _images.asStateFlow()

    fun runPrediction(
        token: String,
        modelImageBase64: String,
        garmentImageBase64: String
    ) {
        viewModelScope.launch {
            try {
                _status.value = "Submitting prediction..."

                val inputs = Inputs(
                    model_image = modelImageBase64,
                    garment_image = garmentImageBase64
                )
                val request = TryOnRequest(inputs = inputs)

                val response = apiService.runPrediction(
                    authHeader = "Bearer $token",
                    request = request
                )

                if (response.isSuccessful) {
                    val id = response.body()?.id ?: ""
                    _status.value = "Prediction submitted. Polling status..."
                    pollPredictionStatus(token, id)
                } else {
                    _status.value = "Error: ${response.code()} - ${response.message()}"
                }

            } catch (e: Exception) {
                _status.value = "Exception: ${e.localizedMessage}"
            }
        }
    }

    private fun pollPredictionStatus(token: String, id: String) {
        viewModelScope.launch {
            repeat(10) {
                try {
                    val statusResponse = apiService.getPredictionStatus(id, "Bearer $token")
                    if (statusResponse.isSuccessful) {
                        val body = statusResponse.body()
                        when (body?.status) {
                            "succeeded" -> {
                                _status.value = "Prediction complete!"
                                _images.value = body.output?.images ?: emptyList()
                                return@launch
                            }
                            "processing" -> {
                                _status.value = "Processing..."
                            }
                            else -> {
                                _status.value = "Failed: ${body?.error}"
                                return@launch
                            }
                        }
                    } else {
                        _status.value = "Status check failed: ${statusResponse.message()}"
                        return@launch
                    }
                } catch (e: Exception) {
                    _status.value = "Exception: ${e.localizedMessage}"
                    return@launch
                }

                delay(2000) // wait 2 seconds before polling again
            }
            _status.value = "Timed out waiting for prediction"
        }
    }
}
