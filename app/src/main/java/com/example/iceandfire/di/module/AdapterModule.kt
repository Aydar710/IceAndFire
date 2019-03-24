package com.example.iceandfire.di.module

import com.example.iceandfire.CharacterListAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun provideCharacletListAdapter() : CharacterListAdapter =
            CharacterListAdapter()
}