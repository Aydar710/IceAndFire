package com.example.iceandfire.viewModel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.repositories.IceAndFireRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class DetailsFragmentViewModel
@Inject constructor(private val repository: IceAndFireRepository) : ViewModel() {

    var specificCharacter: MutableLiveData<CharacterResponse> = MutableLiveData()

    private var getSpecificCharacterJob: Job? = null

    @SuppressLint("CheckResult")
    fun loadCharacter(num: String) {
        getSpecificCharacterJob = CoroutineScope(Dispatchers.IO).launch {
            try {
                val character = repository.getSpecificCharacter(num)
                withContext(Dispatchers.Main) {
                    specificCharacter.value = character
                }
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        getSpecificCharacterJob?.cancel()
        super.onCleared()
    }
}
