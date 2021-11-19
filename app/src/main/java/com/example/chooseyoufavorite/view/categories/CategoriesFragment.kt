package com.example.chooseyoufavorite.view.categories

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.utilities.ViewBindingFragment
import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding
import com.example.chooseyoufavorite.view.HomeFragment
import com.example.chooseyoufavorite.viewmodel.CategoriesViewModel

class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {

    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recyclerview
        val adapter = CategoriesAdapter()
        val recyclerView: RecyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // UserViewModel
        categoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        categoriesViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })
    }

}