package com.example.iceandfire.viewModel

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import com.example.iceandfire.di.component.DaggerAdapterComponent
import com.example.iceandfire.di.component.DaggerRepositoryComponent
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.repositories.IceAndFireRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Retrofit

class CharacterListViewModel : ViewModel() {

    //private var repository : IceAndFireRepository? = null

    /*init {
        repository = DaggerRepositoryComponent.create().getRepository()
    }*/

    private var charactersFlowable: Flowable<CharacterResponse> = loadCharacters()!!
    var charactersLiveData =
        LiveDataReactiveStreams.fromPublisher(charactersFlowable)

    var characterListLiveData: MutableLiveData<List<CharacterResponse>> = MutableLiveData()


    private fun loadCharacters() =
        Flowable.just(CharacterResponse(name = "John Snow"))

    @SuppressLint("CheckResult")
    fun loadData() {
        Flowable.just(CharacterResponse())
    }
}
