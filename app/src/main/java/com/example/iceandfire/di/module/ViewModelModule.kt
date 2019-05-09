package com.example.iceandfire.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iceandfire.di.ViewModelFactory
import com.example.iceandfire.di.ViewModelKey
import com.example.iceandfire.viewModel.CharacterListViewModel
import com.example.iceandfire.viewModel.DetailsFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    abstract fun bindCharacterListViewModel(viewModel: CharacterListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsFragmentViewModel::class)
    abstract fun bindDetailsFragmentViewModel(viewModel: DetailsFragmentViewModel): DetailsFragmentViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}