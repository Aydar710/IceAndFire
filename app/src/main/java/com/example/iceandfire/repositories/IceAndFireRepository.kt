package com.example.iceandfire.repositories

import com.example.iceandfire.pojo.CharacterResponse
import io.reactivex.Single
import javax.inject.Inject

class IceAndFireRepository
@Inject constructor(val service: IceAndFireService) {

    fun getAllCharacters(): Single<CharacterResponse> =
        service.getAllCharacters()

    fun getSpecificCharacter(num: String): Single<CharacterResponse> =
        service.getSpecificCharacter(num)
}
