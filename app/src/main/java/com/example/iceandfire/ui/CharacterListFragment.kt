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
import com.example.iceandfire.di.module.AppModule
import com.example.iceandfire.di.module.NetModule
import com.example.iceandfire.di.module.RepositoryModule
import com.example.iceandfire.di.module.ServiceModule
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.repositories.IceAndFireRepository
import com.example.iceandfire.repositories.IceAndFireService
import com.example.iceandfire.viewModel.CharacterListViewModel
import javax.inject.Inject

class CharacterListFragment : Fragment() {

    private var viewModel: CharacterListViewModel? = null

    @Inject
    lateinit var repository : IceAndFireRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val rvCharacters = view.findViewById<RecyclerView>(R.id.recycler_characters)
        val manager = LinearLayoutManager(activity)
        rvCharacters.layoutManager = manager

        val adapter = DaggerAdapterComponent.create().getCharacterListAdapter()
        rvCharacters.adapter = adapter

        DaggerRepositoryComponent.builder()
            .appModule(activity?.let { AppModule(it) })
            .netModule(NetModule())
            .serviceModule(ServiceModule())
            .repositoryModule(RepositoryModule())
            .build()
            .inject(this)


        viewModel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
        viewModel?.setRepository(repository)

        viewModel?.charactersLiveData?.observe(this, Observer<CharacterResponse> {
            val list = mutableListOf<CharacterResponse>()
            it?.let { character ->
                list.add(character)
            }
            adapter.submitList(list)
        })
        return view
    }
}
