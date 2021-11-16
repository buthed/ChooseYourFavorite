package com.example.chooseyoufavorite.view


import com.example.chooseyoufavorite.ViewBindingFragment
import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding

class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {

    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}