package com.example.iceandfire.di.module

import com.example.iceandfire.repositories.IceAndFireService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetModule::class])
class ServiceModule {

    @Provides
    @Singleton
    fun provideIceAndFireService(retrofit: Retrofit) =
        retrofit.create(IceAndFireService::class.java)
}
