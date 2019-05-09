package com.example.iceandfire.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iceandfire.App
import com.example.iceandfire.CharacterListAdapter
import com.example.iceandfire.R
import com.example.iceandfire.viewModel.CharacterListViewModel
import javax.inject.Inject

class CharacterListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter : CharacterListAdapter

    lateinit var characterListViewModel: CharacterListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.appComponent.inject(this)

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val rvCharacters = view.findViewById<RecyclerView>(R.id.recycler_characters)
        val manager = LinearLayoutManager(activity)
        rvCharacters.layoutManager = manager

        rvCharacters.adapter = adapter

        characterListViewModel = ViewModelProviders
            .of(this, viewModelFactory)[CharacterListViewModel::class.java]

        /*characterListViewModel.charactersLiveData.observe(this, Observer<CharacterResponse> {
            val list = mutableListOf<CharacterResponse>()
            it?.let { character ->
                list.add(character)
            }
            adapter.submitList(list)
        })*/
        return view
    }
}
