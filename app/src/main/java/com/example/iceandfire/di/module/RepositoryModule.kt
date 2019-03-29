package com.example.iceandfire.di.module

import com.example.iceandfire.di.scope.RepoScope
import com.example.iceandfire.repositories.IceAndFireRepository
import com.example.iceandfire.repositories.IceAndFireService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ServiceModule::class, AppModule::class])
class RepositoryModule {

    @Provides
    @RepoScope
    fun provideIceAndFireRepository(iceAndFireService: IceAndFireService): IceAndFireRepository =
        IceAndFireRepository(iceAndFireService)
}
