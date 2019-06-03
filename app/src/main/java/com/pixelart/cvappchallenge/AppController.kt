package com.pixelart.cvappchallenge

import android.app.Application
import com.pixelart.cvappchallenge.DI.ApplicationComponent
import com.pixelart.cvappchallenge.DI.DaggerApplicationComponent
import com.pixelart.cvappchallenge.DI.NetworkModule

class AppController: Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }
}