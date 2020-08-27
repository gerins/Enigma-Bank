package com.example.enigmabank

import android.app.Application

class MyApplication : Application() {
    val applicationComponent = DaggerApplicationComponent.create()
}