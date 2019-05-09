package com.example.iceandfire.viewModel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.repositories.IceAndFireRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CharacterListViewModel
@Inject constructor(private val repository: IceAndFireRepository) : ViewModel() {

    var characterList: MutableLiveData<List<CharacterResponse>> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun loadCharacters() {
        repository.getAllCharacters()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    characterList.value = mutableListOf(it)
                }, {
                    it.printStackTrace()
                })
    }
}

