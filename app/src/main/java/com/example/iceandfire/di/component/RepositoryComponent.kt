package com.example.iceandfire.di.component

import com.example.iceandfire.di.module.RepositoryModule
import com.example.iceandfire.di.scope.RepoScope
import com.example.iceandfire.ui.CharacterListFragment
import com.example.iceandfire.ui.DetailsFragment
import dagger.Component
import javax.inject.Singleton

@RepoScope
@Component(dependencies = [AppComponent::class], modules = [RepositoryModule::class])
interface RepositoryComponent {

    fun inject(characterListFragment: CharacterListFragment)
    fun inject(detailsFragment: DetailsFragment)
}
