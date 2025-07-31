package com.example.dvyb.data.remote.tryon

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: TryOnApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.fashn.ai/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TryOnApiService::class.java)
    }
}
