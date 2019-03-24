package com.example.iceandfire.di.component

import com.example.iceandfire.CharacterListAdapter
import com.example.iceandfire.di.module.AdapterModule
import dagger.Component


@Component(modules = [AdapterModule::class])
interface AdapterComponent {
    fun getCharacterListAdapter(): CharacterListAdapter
}