package com.example.enigmabank.model.user

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UserAPI {
    @POST("/user/login")
    fun requestUserLogin(@Body user: User): Call<User>

    @Multipart
    @POST("/menu")
    fun uploadImages(@Part imagename: MultipartBody.Part) : Call<User>
}