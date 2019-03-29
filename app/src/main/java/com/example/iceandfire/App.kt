package com.example.iceandfire

import android.app.Activity
import android.app.Application
import com.example.iceandfire.di.component.AppComponent
import com.example.iceandfire.di.component.DaggerAppComponent
import com.example.iceandfire.di.module.AppModule
import com.example.iceandfire.di.module.ServiceModule
import com.example.iceandfire.di.module.NetModule



class App : Application() {

    companion object {
        lateinit var appComponent : AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule())
            .serviceModule(ServiceModule())
            .build()
    }
}
