package com.example.iceandfire.di.component

import android.content.Context
import com.example.iceandfire.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun provideContext() : Context
}