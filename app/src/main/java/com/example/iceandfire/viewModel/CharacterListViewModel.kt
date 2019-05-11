package com.example.iceandfire.viewModel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.repositories.IceAndFireRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class CharacterListViewModel
@Inject constructor(private val repository: IceAndFireRepository) : ViewModel() {

    var characterList: MutableLiveData<List<CharacterResponse>> = MutableLiveData()

    private var getAllCharactersJob: Job? = null

    @SuppressLint("CheckResult")
    fun loadCharacters() {
        getAllCharactersJob = CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = repository.getAllCharacters()
                withContext(Dispatchers.Main) {
                    characterList.value = characters
                }
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        getAllCharactersJob?.cancel()
        super.onCleared()
    }
}

