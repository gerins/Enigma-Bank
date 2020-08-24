package com.example.enigmabank.model.user

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/user/login")
    fun requestUserLogin(@Body user: User): Call<User>
}