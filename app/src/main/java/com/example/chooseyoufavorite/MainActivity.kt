package com.example.chooseyoufavorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chooseyoufavorite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment.newInstance()).commit()
    }
}