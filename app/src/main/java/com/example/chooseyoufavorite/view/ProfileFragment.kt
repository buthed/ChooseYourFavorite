package com.example.chooseyoufavorite.view

import com.example.chooseyoufavorite.databinding.FragmentProfileBinding
import com.example.chooseyoufavorite.utilities.ViewBindingFragment

class ProfileFragment : ViewBindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object{
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }
}