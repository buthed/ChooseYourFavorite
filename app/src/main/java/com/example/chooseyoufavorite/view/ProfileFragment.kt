package com.example.chooseyoufavorite.view

import com.example.chooseyoufavorite.ViewBindingFragment
import com.example.chooseyoufavorite.databinding.FragmentProfileBinding

class ProfileFragment : ViewBindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object{
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }
}