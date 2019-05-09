package com.example.iceandfire.viewModel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.repositories.IceAndFireRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class DetailsFragmentViewModel
@Inject constructor(private val repository: IceAndFireRepository) : ViewModel() {

    var specificCharacter: MutableLiveData<CharacterResponse> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun loadCharacter(num: String) {
        repository.getSpecificCharacter(num)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                specificCharacter.value = it
            }, {
                it.printStackTrace()
            })
    }
}
