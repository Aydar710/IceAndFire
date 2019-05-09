package com.example.iceandfire.repositories

import com.example.iceandfire.pojo.CharacterResponse
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

//class IceAndFireRepository(val service: IceAndFireService) {
class IceAndFireRepository
@Inject constructor(val service: IceAndFireService) {

    fun getAllCharacters(): Flowable<CharacterResponse> =
        service.getAllCharacters()

    fun getSpecificCharacter(num: String): Single<CharacterResponse> =
        service.getSpecificCharacter(num)
}
