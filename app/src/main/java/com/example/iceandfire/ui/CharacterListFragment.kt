package com.example.iceandfire.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iceandfire.App
import com.example.iceandfire.CharacterListAdapter
import com.example.iceandfire.R
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.viewModel.CharacterListViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import javax.inject.Inject

class CharacterListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var characterListViewModel: CharacterListViewModel

    lateinit var adapter: CharacterListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.component.inject(this)

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val rvCharacters = view.recycler_characters

        adapter = CharacterListAdapter()
        rvCharacters.adapter = adapter

        characterListViewModel = ViewModelProviders
                .of(this, viewModelFactory)[CharacterListViewModel::class.java]


        characterListViewModel.characterList.observe(this, Observer<List<CharacterResponse>> {
            adapter.submitList(it)
        })

        characterListViewModel.loadCharacters()
        return view
    }
}
