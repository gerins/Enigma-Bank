package com.example.enigmabank.utility

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        val BASE_URL = "http://localhost:8080"

        fun createRetrofit(): Retrofit {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }
    }
}