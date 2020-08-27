package com.example.enigmabank.model.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enigmabank.utility.RetrofitBuilder
import okhttp3.MultipartBody
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    fun getUserInfo() = userRepository.userInfo as LiveData<User>
    fun requestUserLogin(user: User) = userRepository.requestUserLogin(user)
    fun uploadImage(image: MultipartBody.Part) = userRepository.uploadImage(image)
}