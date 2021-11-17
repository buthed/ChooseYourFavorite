package com.example.chooseyoufavorite.view.categories

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.ViewBindingFragment
import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding
import com.example.chooseyoufavorite.view.HomeFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = binding.textView1
        val database = Firebase.database
        val myRef = database.getReference("Movies")

        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value: String = (snapshot.getValue().toString()) as String
                textView.setText(value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })
    }

    private fun getCategoryList(): List<String> {
        return this.resources.getStringArray(R.array.categories).toList()
    }

    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}