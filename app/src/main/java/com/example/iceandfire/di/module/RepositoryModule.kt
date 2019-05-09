package com.example.iceandfire.di.module

import com.example.iceandfire.repositories.IceAndFireRepository
import com.example.iceandfire.repositories.IceAndFireService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideIceAndFireRepository(iceAndFireService: IceAndFireService): IceAndFireRepository =
        IceAndFireRepository(iceAndFireService)
}
