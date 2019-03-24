package com.example.iceandfire.repositories

import com.example.iceandfire.pojo.CharacterResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface IceAndFireService {

    @GET("")
    fun getAllCharacters(): Flowable<CharacterResponse>
}