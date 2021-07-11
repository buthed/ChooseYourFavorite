package com.example.chooseyoufavorite.View.Adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chooseyoufavorite.View.Fragments.ARG_OBJECT
import com.example.chooseyoufavorite.View.Fragments.NumberFragment

class NumberAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        val fragment = NumberFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }

}