package com.example.iceandfire.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.iceandfire.R
import com.facebook.stetho.Stetho

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this)

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
