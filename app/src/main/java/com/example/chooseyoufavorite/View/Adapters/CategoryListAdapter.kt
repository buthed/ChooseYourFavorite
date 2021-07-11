package com.example.chooseyoufavorite.View.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.Models.CategoryList
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.View.Fragments.MainFragment
import com.squareup.picasso.Picasso

class CategoryListAdapter(private var itemClickListener:
                          MainFragment.OnItemViewClickListener
) :
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
                Log.d("Card","clicked!")
            }
        }
    }

}