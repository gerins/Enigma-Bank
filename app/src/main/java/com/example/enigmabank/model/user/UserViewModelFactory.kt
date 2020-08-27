package com.example.enigmabank.model.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enigmabank.utility.RetrofitBuilder

class UserViewModelFactory(private val userRepository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }
}

object InjectorUtility {
    fun provideUserViewModelFactory(): UserViewModelFactory {
        val userRepository =
            UserRepository(RetrofitBuilder.createRetrofit().create(UserAPI::class.java))
        return UserViewModelFactory(userRepository)
    }
}
