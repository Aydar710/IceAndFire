package com.example.iceandfire.repositories

import com.example.iceandfire.pojo.CharacterResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

class IceAndFireRepository(val service: IceAndFireService) {

    fun getAllCharacters(): Flowable<CharacterResponse> =
        service.getAllCharacters()

    fun getSpecificCharacter(num : String): Single<CharacterResponse> =
            service.getSpecificCharacter(num)
}
