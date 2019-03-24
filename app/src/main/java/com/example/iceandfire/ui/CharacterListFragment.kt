package com.example.iceandfire.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iceandfire.R
import com.example.iceandfire.di.component.DaggerAdapterComponent
import com.example.iceandfire.di.component.DaggerRepositoryComponent
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.viewModel.CharacterListViewModel

class CharacterListFragment : Fragment() {

    private var viewModel: CharacterListViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val rvCharacters = view.findViewById<RecyclerView>(R.id.recycler_characters)
        val manager = LinearLayoutManager(activity)
        rvCharacters.layoutManager = manager

        val adapter = DaggerAdapterComponent.create().getCharacterListAdapter()
        rvCharacters.adapter = adapter

        val repository = DaggerRepositoryComponent.create().getRepository()

        viewModel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)

        /*viewModel?.characterListLiveData?.observe(this, Observer<List<CharacterResponse>> {
            adapter.submitList(it)
        })*/
        return view
    }
}