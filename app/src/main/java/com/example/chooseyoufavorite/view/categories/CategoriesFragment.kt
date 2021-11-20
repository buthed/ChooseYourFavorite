package com.example.chooseyoufavorite.view.categories

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding
import com.example.chooseyoufavorite.utilities.ViewBindingFragment
import com.example.chooseyoufavorite.viewmodel.CategoriesViewModel

class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {

    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recyclerview
        val adapter = CategoriesAdapter()
        val recyclerView: RecyclerView = binding.recyclerviewCategories
        recyclerView.adapter = adapter
        // UserViewModel
        categoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        categoriesViewModel.readAllData.observe(viewLifecycleOwner, Observer { categories ->
            adapter.setData(categories)
        })
    }

    companion object {
        const val categoryKey = "CATEGORY_NAME"
    }

}