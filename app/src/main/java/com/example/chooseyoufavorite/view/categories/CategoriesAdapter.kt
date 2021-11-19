package com.example.chooseyoufavorite.view.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity
import kotlinx.android.synthetic.main.fragment_categories_item.view.*


class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    private var categoriesList = emptyList<CategoriesEntity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_categories_item, parent, false))
    }

    override fun getItemCount() = categoriesList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoriesList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.categories_type
        holder.itemView.lastName_txt.text = currentItem.name
        holder.itemView.age_txt.text = currentItem.name.toString()

    }

    fun setData(categories: List<CategoriesEntity>){
        this.categoriesList = categories
        notifyDataSetChanged()
    }

}