package com.example.chooseyoufavorite


import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding

class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {

    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}