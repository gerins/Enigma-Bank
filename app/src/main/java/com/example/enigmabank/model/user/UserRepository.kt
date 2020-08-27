package com.example.enigmabank.model.user

import androidx.lifecycle.MutableLiveData
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Multipart
import javax.inject.Inject

class UserRepository @Inject constructor(private val userAPI: UserAPI) {
    var userInfo = MutableLiveData<User>()

    fun uploadImage(image: MultipartBody.Part) {
        userAPI.uploadImages(image).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                println("=============================")
                println(response.body())
                println(response.code())
                println("=============================")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("=============================")
                println(t)
                println("=============================")
            }
        })
    }

    fun requestUserLogin(user: User) {
        userAPI.requestUserLogin(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                println("=============================")
                print("LOGIN SUCCESS -> ")
                println(response.code())
                println(response.body())
                println("=============================")
                userInfo.value = response.body()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("=============================")
                print("LOGIN FAILED -> ")
                println(t)
                println("=============================")
            }
        })
    }
}