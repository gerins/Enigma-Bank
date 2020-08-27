package com.example.enigmabank

import com.example.enigmabank.model.user.UserAPI
import com.example.enigmabank.utility.RetrofitBuilder
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideUserAPI(): UserAPI {
        return RetrofitBuilder.createRetrofit().create(UserAPI::class.java)
    }
}