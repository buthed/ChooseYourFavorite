package com.example.chooseyoufavorite

import com.example.chooseyoufavorite.databinding.FragmentProfileBinding

class ProfilesFragment : ViewBindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    
    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}