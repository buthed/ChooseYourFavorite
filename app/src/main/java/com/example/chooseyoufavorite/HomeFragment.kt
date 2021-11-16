package com.example.chooseyoufavorite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.chooseyoufavorite.databinding.FragmentHomeBinding

class HomeFragment : ViewBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {



    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}