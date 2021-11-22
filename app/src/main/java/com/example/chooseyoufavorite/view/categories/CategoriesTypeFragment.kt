package com.example.chooseyoufavorite.view.categories

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.databinding.FragmentCategoriesTypeBinding
import com.example.chooseyoufavorite.utilities.ViewBindingFragment
import com.example.chooseyoufavorite.viewmodel.AppStateCateg
import com.example.chooseyoufavorite.viewmodel.CategoriesTypeViewModel

class CategoriesTypeFragment
    : ViewBindingFragment<FragmentCategoriesTypeBinding>(FragmentCategoriesTypeBinding::inflate) {

    private val categoriesTypeViewModel: CategoriesTypeViewModel by lazy { ViewModelProvider(this)
        .get(CategoriesTypeViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // UserViewModel
        categoriesTypeViewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        categoriesTypeViewModel.getCategories()
    }

    private fun renderData(appState: AppStateCateg) {
        when (appState) {
            is AppStateCateg.Success -> {
//                binding.recyclerviewCategoryType.visibility = View.VISIBLE //TODO Loading, Error
                val adapter = initCategoriesTypeAdapter()
                adapter.setData(appState.categoryData)
            }
//            is AppStateCateg.Loading -> {
//                binding.recyclerviewCategoryType.visibility = View.GONE
//            }
//            is AppStateCateg.Error -> {
//                binding.recyclerviewCategoryType.visibility = View.VISIBLE
//            }
        }
    }

    private fun initCategoriesTypeAdapter(): CategoriesTypeAdapter {
        val adapter = CategoriesTypeAdapter()
        val recyclerView: RecyclerView = binding.recyclerviewCategoryType
        recyclerView.adapter = adapter
        return adapter
    }

}