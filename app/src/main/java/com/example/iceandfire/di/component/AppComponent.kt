package com.example.iceandfire.di.component

import android.content.Context
import com.example.iceandfire.di.module.AppModule
import com.example.iceandfire.di.module.NetModule
import com.example.iceandfire.di.module.ServiceModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetModule::class, ServiceModule::class])
@Singleton
interface AppComponent {

    fun provideContext() : Context
}