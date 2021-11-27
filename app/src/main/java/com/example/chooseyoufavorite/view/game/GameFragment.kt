package com.example.chooseyoufavorite.view.game

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.databinding.FragmentGameBinding
import com.example.chooseyoufavorite.utilities.ViewBindingFragment
import com.example.chooseyoufavorite.view.categories.CategoriesAdapter
import com.example.chooseyoufavorite.viewmodel.AppStateCategGame
import com.example.chooseyoufavorite.viewmodel.GameViewModel

class GameFragment : ViewBindingFragment<FragmentGameBinding>(FragmentGameBinding::inflate) {

    private val gameViewModel: GameViewModel by lazy { ViewModelProvider(this)
        .get(GameViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gameTitle.setText(arguments?.getString(categoryName) ?: String())

        gameViewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        gameViewModel.getTop250Movies()
    }

    private fun renderData(appState: AppStateCategGame) {
        when (appState) {
            is AppStateCategGame.Success -> {
                binding.recyclerviewGame.visibility = View.VISIBLE
                // Recyclerview Init
                val adapter = GameAdapter()
                val recyclerView: RecyclerView = binding.recyclerviewGame
                recyclerView.adapter = adapter
                adapter.setData(appState.cardsGame)
            }
            is AppStateCategGame.Loading -> {
                binding.recyclerviewGame.visibility = View.GONE
            }
            is AppStateCategGame.Error -> {
                binding.recyclerviewGame.visibility = View.VISIBLE
            }
        }
    }

    companion object{
        const val categoryName = "Movies"
        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }
}