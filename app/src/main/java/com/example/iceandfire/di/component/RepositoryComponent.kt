package com.example.iceandfire.di.component

import com.example.iceandfire.di.module.NetModule
import com.example.iceandfire.di.module.RepositoryModule
import com.example.iceandfire.di.module.ServiceModule
import com.example.iceandfire.di.scope.RepoScope
import com.example.iceandfire.repositories.IceAndFireRepository
import com.example.iceandfire.ui.CharacterListFragment
import com.example.iceandfire.ui.DetailsFragment
import dagger.Component

@RepoScope
@Component(dependencies = [AppComponent::class], modules = [RepositoryModule::class])
interface RepositoryComponent {

    fun inject(characterListFragment: CharacterListFragment)
    fun inject(detailsFragment: DetailsFragment)

    fun getRepository(): IceAndFireRepository
}
