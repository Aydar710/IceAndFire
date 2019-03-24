package com.example.iceandfire.di.component

import com.example.iceandfire.di.module.RepositoryModule
import com.example.iceandfire.repositories.IceAndFireRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface RepositoryComponent {
    fun getRepository(): IceAndFireRepository
}
