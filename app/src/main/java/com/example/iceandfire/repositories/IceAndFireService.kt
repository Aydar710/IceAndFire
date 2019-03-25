package com.example.iceandfire.repositories

import com.example.iceandfire.pojo.CharacterResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IceAndFireService {

    @GET("")
    fun getAllCharacters(): Flowable<CharacterResponse>

    @GET("/{characterNum}")
    fun getSpecificCharacter(@Path("characterNum") num : String) : Single<CharacterResponse>
}