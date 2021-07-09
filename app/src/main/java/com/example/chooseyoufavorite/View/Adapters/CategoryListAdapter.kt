package com.example.chooseyoufavorite.View.Adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.Models.CategoryList
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.View.Fragments.MoviesFragment
import com.example.chooseyoufavorite.databinding.FragmentMoviesBinding
import com.squareup.picasso.Picasso

import java.util.*

class CategoryListAdapter(private var itemClickListener:
                          MoviesFragment.OnItemViewClickListener?) :
    RecyclerView.Adapter<CategoryListAdapter.MainViewHolder>() {

    private var categoryData: List<CategoryList> = listOf()
    fun setCategory(data: List<CategoryList>) {
        categoryData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(categoryData[position])
    }

    override fun getItemCount(): Int {
        return categoryData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(category: CategoryList) {
            itemView.findViewById<TextView>(R.id.itemTitle).text = category.name
            val urlPoster: String = category.backdrop_path.toString()
            Picasso.get().load(urlPoster).into(itemView.findViewById<ImageView>(R.id.itemBanner))
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    category.name,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}