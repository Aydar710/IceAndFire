package com.example.iceandfire.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iceandfire.ARG_CHARACTER_NUM
import com.example.iceandfire.R
import com.example.iceandfire.pojo.CharacterResponse
import com.example.iceandfire.viewModel.DetailsFragmentViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailsFragment : Fragment() {

    private var num: String? = null
    private var viewModel: DetailsFragmentViewModel? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    companion object {
        @JvmStatic
        fun newInstance(num: String) =
                DetailsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_CHARACTER_NUM, num)
                    }
                }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        arguments?.let {
            num = it.getString(ARG_CHARACTER_NUM)
        }

        viewModel = ViewModelProviders.of(this)[DetailsFragmentViewModel::class.java]
        viewModel?.specificCharacter?.observe(this, Observer<CharacterResponse> {
            it?.let { character -> bindTextViews(character) }
        })

        num?.let { viewModel?.loadCharacter(it) }
        return view
    }

    fun bindTextViews(character: CharacterResponse) {
        txt_name.text = character.name
        txt_birth_date.text = character.born
        txt_death_date.text = character.died
        txt_played_by.text = character.playedBy.toString()
    }

}