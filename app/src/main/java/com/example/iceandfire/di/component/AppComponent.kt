package com.example.iceandfire.di.component

import android.content.Context
import com.example.iceandfire.di.module.AppModule
import com.example.iceandfire.di.module.NetModule
import com.example.iceandfire.di.module.ServiceModule
import com.example.iceandfire.repositories.IceAndFireService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class, ServiceModule::class])
interface AppComponent {

    fun provideContext() : Context

    fun iceAndFireService() : IceAndFireService
}