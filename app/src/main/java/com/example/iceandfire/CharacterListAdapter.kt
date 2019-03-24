package com.example.iceandfire

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iceandfire.pojo.CharacterResponse
import kotlinx.android.extensions.LayoutContainer

class CharacterListAdapter :
    ListAdapter<CharacterResponse, CharacterListAdapter.CharacterHolder>(CharacterDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CharacterListAdapter.CharacterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_character, parent, false)
        return CharacterHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CharacterHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        var txtName = containerView.findViewById<TextView>(R.id.txt_character_name)

        fun bind(character: CharacterResponse) {
            txtName.text = character.name
        }
    }
}
