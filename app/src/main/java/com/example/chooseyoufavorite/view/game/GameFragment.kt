package com.example.chooseyoufavorite.view.game

import android.os.Bundle
import android.view.View
import com.example.chooseyoufavorite.databinding.FragmentGameBinding
import com.example.chooseyoufavorite.utilities.ViewBindingFragment

class GameFragment : ViewBindingFragment<FragmentGameBinding>(FragmentGameBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gameTitle.setText(arguments?.getString(categoryName) ?: String())
    }

    companion object{
        const val categoryName = "Movies"
        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }
}