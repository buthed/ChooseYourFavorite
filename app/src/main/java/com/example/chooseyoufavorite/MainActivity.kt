package com.example.chooseyoufavorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.chooseyoufavorite.view.HomeFragment
import com.example.chooseyoufavorite.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState==null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commit()
        }
        init()
    }

    private fun init() {
        //Initialize the bottom navigation view
        //Create bottom navigation view object
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.container)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navHome,
                R.id.navCategories,
                R.id.navHome
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
        //Initialize Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference()
    }
}