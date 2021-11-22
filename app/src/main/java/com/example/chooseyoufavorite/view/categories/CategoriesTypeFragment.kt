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

class CategoriesTypeFragment : ViewBindingFragment<FragmentCategoriesTypeBinding>(FragmentCategoriesTypeBinding::inflate) {

    //private lateinit var categoriesTypeViewModel: CategoriesTypeViewModel
    private val categoriesTypeViewModel: CategoriesTypeViewModel by lazy { ViewModelProvider(this).get(CategoriesTypeViewModel::class.java) }
//    private val adapter: CategoriesTypeAdapter by lazy { CategoriesTypeAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Recyclerview
        val adapter = CategoriesTypeAdapter()
        val recyclerView: RecyclerView = binding.recyclerviewCategoryType
        recyclerView.adapter = adapter

        // UserViewModel
        //categoriesTypeViewModel = ViewModelProvider(this).get(CategoriesTypeViewModel::class.java)
        categoriesTypeViewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        categoriesTypeViewModel.getCategories()
    }

    private fun renderData(appState: AppStateCateg) {
        when (appState) {
            is AppStateCateg.Success -> {
//                binding.recyclerviewCategoryType.visibility = View.VISIBLE
                val adapter = CategoriesTypeAdapter()
                val recyclerView: RecyclerView = binding.recyclerviewCategoryType
                recyclerView.adapter = adapter
                adapter.setData(appState.weatherData)
            }
//            is AppStateCateg.Loading -> {
//                binding.recyclerviewCategoryType.visibility = View.GONE
//            }
//            is AppStateCateg.Error -> {
//                binding.recyclerviewCategoryType.visibility = View.VISIBLE
//            }
        }
    }

}