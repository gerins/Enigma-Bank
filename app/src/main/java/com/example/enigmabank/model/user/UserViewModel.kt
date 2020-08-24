package com.example.enigmabank.model.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enigmabank.utility.RetrofitBuilder

class UserViewModel: ViewModel() {
    private val userRepository = UserRepository(RetrofitBuilder.createRetrofit().create(UserAPI::class.java))

    fun getUserInfo() = userRepository.userInfo as LiveData<User>
    fun requestUserLogin(user: User) = userRepository.requestUserLogin(user)
}