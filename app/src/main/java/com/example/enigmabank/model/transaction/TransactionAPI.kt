package com.example.enigmabank.model.transaction

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransactionAPI {
    @GET("/transaction/{id}")
    fun fetchUserTransactionList(@Path("id") id: String): Call<List<Transaction>>

    @POST("/transaction")
    fun fetchPostNewTransaction(@Body transaction: Transaction): Call<Transaction>
}