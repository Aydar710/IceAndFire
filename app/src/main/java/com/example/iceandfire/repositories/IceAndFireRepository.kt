package com.example.iceandfire.repositories

import com.example.iceandfire.pojo.CharacterResponse
import javax.inject.Inject

class IceAndFireRepository
@Inject constructor(val service: IceAndFireService) {

    suspend fun getAllCharacters(): List<CharacterResponse> {
        val result = service.getAllCharacters().await()
        return mutableListOf(result)
    }

    suspend fun getSpecificCharacter(num: String): CharacterResponse {
        val result = service.getSpecificCharacter(num).await()
        return result
    }
}
