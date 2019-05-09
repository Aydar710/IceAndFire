package com.example.iceandfire.viewModel

import android.arch.lifecycle.ViewModel
import com.example.iceandfire.repositories.IceAndFireRepository
import javax.inject.Inject

class CharacterListViewModel
@Inject constructor(private val repository: IceAndFireRepository) : ViewModel() {

    /*init {
        repository = DaggerRepositoryComponent.create().getRepository()
    }*/

    /*private var charactersFlowable: Flowable<CharacterResponse> = loadCharacters()
    var charactersLiveData =
        LiveDataReactiveStreams.fromPublisher(charactersFlowable)

    private fun loadCharacters(): Flowable<CharacterResponse> =
        repository.getAllCharacters() ?: Flowable.just(CharacterResponse())

    fun setRepository(repository: IceAndFireRepository) {
        //TODO: Delete method
    }*/
}
