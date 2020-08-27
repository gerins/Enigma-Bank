package com.example.enigmabank

import com.example.enigmabank.fragments.user.UserLoginFragment
import com.example.enigmabank.fragments.user.UserMainMenuFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(userLoginFragment: UserLoginFragment)
    fun inject(userMainMenuFragment: UserMainMenuFragment)
}