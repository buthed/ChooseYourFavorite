package com.example.chooseyoufavorite.view.categories

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding
import com.example.chooseyoufavorite.utilities.ViewBindingFragment
import com.example.chooseyoufavorite.viewmodel.AppStateCategByType
import com.example.chooseyoufavorite.viewmodel.CategoriesViewModel

class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate), OnClickAdapterItem {

    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainCategory.text = arguments?.getString(categoryKey) ?: String()

        // UserViewModel Init
        categoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        categoriesViewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        categoriesViewModel.getCategoriesByType(arguments?.getString(categoryKey) ?: String())
    }

    private fun renderData(appState: AppStateCategByType) {
        when (appState) {
            is AppStateCategByType.Success -> {
                binding.recyclerviewCategories.visibility = View.VISIBLE
                // Recyclerview Init
                val adapter = CategoriesAdapter()
                val recyclerView: RecyclerView = binding.recyclerviewCategories
                recyclerView.adapter = adapter
                adapter.setData(appState.categoryDataByType)
            }
            is AppStateCategByType.Loading -> {
                binding.recyclerviewCategories.visibility = View.GONE
            }
            is AppStateCategByType.Error -> {
                binding.recyclerviewCategories.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        const val categoryKey = "Movies"
    }

    override fun onItemClick(name: String, position: Int) {
        categoriesViewModel.getCategoriesByType(name)
    }
}