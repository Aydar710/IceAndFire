package com.example.iceandfire

import android.app.Application
import com.example.iceandfire.di.component.AppComponent
import com.example.iceandfire.di.component.DaggerAppComponent
import com.example.iceandfire.di.module.AppModule
import com.facebook.stetho.Stetho


class App : Application() {

    companion object {
        @Suppress("LateinitUsage")
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}
