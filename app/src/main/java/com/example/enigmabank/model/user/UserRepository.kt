package com.example.enigmabank.model.user

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(val userAPI: UserAPI) {
    var userInfo = MutableLiveData<User>()

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