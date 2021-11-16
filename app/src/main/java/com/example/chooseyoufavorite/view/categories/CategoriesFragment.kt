package com.example.chooseyoufavorite.view.categories

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.ViewBindingFragment
import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding
import com.example.chooseyoufavorite.view.HomeFragment
import com.google.firebase.database.*

class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {

    private lateinit var mDatabase: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDatabase = FirebaseDatabase.getInstance().getReference("Top250Movie")
        val recyclerView: RecyclerView = binding.recyclerViewCategories
        recyclerView.adapter = CategoriesAdapter(getCatList())
    }

    private fun getCatList(): List<String> {
        return this.resources.getStringArray(R.array.categories).toList()
    }

    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}