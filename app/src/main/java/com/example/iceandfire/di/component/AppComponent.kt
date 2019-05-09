package com.example.iceandfire.di.component

import android.content.Context
import com.example.iceandfire.di.module.*
import com.example.iceandfire.repositories.IceAndFireService
import com.example.iceandfire.ui.CharacterListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        ServiceModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        AdapterModule::class
    ]
)
interface AppComponent {

    fun provideContext(): Context

    fun iceAndFireService(): IceAndFireService

    fun inject(characterListFragment: CharacterListFragment)
}