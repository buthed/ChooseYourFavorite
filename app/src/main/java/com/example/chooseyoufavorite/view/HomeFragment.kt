package com.example.chooseyoufavorite.view


import com.example.chooseyoufavorite.ViewBindingFragment
import com.example.chooseyoufavorite.databinding.FragmentHomeBinding

class HomeFragment : ViewBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}