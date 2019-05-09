package com.example.iceandfire.di.module

import android.content.Context
import com.example.iceandfire.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp(): Context = app
}
