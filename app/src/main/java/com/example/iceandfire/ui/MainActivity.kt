package com.example.iceandfire.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.iceandfire.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doCharacterListFragmentTransaction()
    }

    fun doCharacterListFragmentTransaction(){
        val fragmentManager = supportFragmentManager
        val fragment = CharacterListFragment()
        fragmentManager.beginTransaction()
            .replace(R.id.container_main, fragment)
            .commit()
    }
}
