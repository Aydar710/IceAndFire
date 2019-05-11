package com.example.iceandfire.repositories

import com.example.iceandfire.pojo.CharacterResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface IceAndFireService {

    @GET("")
    fun getAllCharacters(): Deferred<CharacterResponse>

    @GET("/{characterNum}")
    fun getSpecificCharacter(@Path("characterNum") num : String) : Deferred<CharacterResponse>
}