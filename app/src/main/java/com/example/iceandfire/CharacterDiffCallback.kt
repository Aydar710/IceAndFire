package com.example.iceandfire

import android.support.v7.util.DiffUtil
import com.example.iceandfire.pojo.CharacterResponse

class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterResponse>() {
    override fun areItemsTheSame(oldCharacter: CharacterResponse, newCharacter: CharacterResponse): Boolean =
        oldCharacter == newCharacter

    override fun areContentsTheSame(oldCharacter: CharacterResponse, newCharacter: CharacterResponse): Boolean =
        oldCharacter.url.equals(newCharacter.url)
}
