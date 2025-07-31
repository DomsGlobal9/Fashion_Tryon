package com.example.dvyb.data.remote.tryon

import com.example.dvyb.data.remote.tryon.TryOnRequest
import com.example.dvyb.data.remote.tryon.TryOnResponse
import com.example.dvyb.data.remote.tryon.TryOnStatusResponse
import retrofit2.Response
import retrofit2.http.*

interface TryOnApiService {

    @POST("v1/run")
    suspend fun runPrediction(
        @Body request: TryOnRequest,
        @Header("Authorization") authHeader: String
    ): Response<TryOnResponse>

    @GET("v1/status/{id}")
    suspend fun getPredictionStatus(
        @Path("id") id: String,
        @Header("Authorization") authHeader: String
    ): Response<TryOnStatusResponse>
}
