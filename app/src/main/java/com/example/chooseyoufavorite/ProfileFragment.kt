package com.example.chooseyoufavorite

import com.example.chooseyoufavorite.databinding.FragmentProfileBinding

class ProfileFragment : ViewBindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object{
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }
}