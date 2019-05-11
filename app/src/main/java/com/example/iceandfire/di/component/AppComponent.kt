package com.example.iceandfire.di.component

import android.content.Context
import com.example.iceandfire.di.module.*
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
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun provideApp(): Context


    fun inject(characterListFragment: CharacterListFragment)
}