package com.example.iceandfire.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.repositories.IceAndFireRepository
import io.reactivex.Single

class DetailsFragmentViewModel : ViewModel() {

    private var repository: IceAndFireRepository? = null

    private var specificCharacterSingle: Single<CharacterResponse> = Single.just(CharacterResponse())

    var specificCharacterLiveData: LiveData<CharacterResponse> =
        LiveDataReactiveStreams.fromPublisher(specificCharacterSingle.toFlowable())


    fun loadCharacter(num: String) =
        repository?.getSpecificCharacter(num) ?: Single.just(CharacterResponse())

    fun setRepository(repository: IceAndFireRepository){
        this.repository = repository
    }
}