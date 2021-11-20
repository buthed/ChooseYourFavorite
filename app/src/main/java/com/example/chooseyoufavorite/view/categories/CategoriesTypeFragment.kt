package com.example.chooseyoufavorite.view.categories

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.databinding.FragmentCategoriesTypeBinding
import com.example.chooseyoufavorite.utilities.ViewBindingFragment
import com.example.chooseyoufavorite.viewmodel.CategoriesTypeViewModel
import com.example.chooseyoufavorite.viewmodel.CategoriesViewModel

class CategoriesTypeFragment : ViewBindingFragment<FragmentCategoriesTypeBinding>(FragmentCategoriesTypeBinding::inflate) {

    private lateinit var categoriesTypeViewModel: CategoriesTypeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recyclerview
        val adapter = CategoriesTypeAdapter()
        val recyclerView: RecyclerView = binding.recyclerviewCategoryType
        recyclerView.adapter = adapter
        // UserViewModel
        categoriesTypeViewModel = ViewModelProvider(this).get(CategoriesTypeViewModel::class.java)
        categoriesTypeViewModel.readAllData.observe(viewLifecycleOwner, Observer { categoriesType ->
            adapter.setData(categoriesType)
        })
    }

}