package com.example.chooseyoufavorite.View.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chooseyoufavorite.MainActivity
import com.example.chooseyoufavorite.View.Fragments.MoviesFragment
import com.example.chooseyoufavorite.View.Fragments.FragmentThree
import com.example.chooseyoufavorite.View.Fragments.FragmentTwo

class MyAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    private val FRAGMENTS_SIZE = 7

    override fun getItemCount(): Int {
        return this.FRAGMENTS_SIZE
    }

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> {
                return MoviesFragment()
            }
            1 -> {
                return FragmentTwo()
            }
            2 -> {
                return FragmentThree()
            }
        }
        return MoviesFragment()
    }
}
