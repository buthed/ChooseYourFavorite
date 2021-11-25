package com.example.chooseyoufavorite.view.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesEntity
import kotlinx.android.synthetic.main.fragment_categories_item.view.*


class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    private var categoriesList = emptyList<CategoriesEntity>()
    private lateinit var listener: OnClickAdapterItem

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_categories_item, parent, false))
    }

    override fun getItemCount() = categoriesList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoriesList[position]
        holder.itemView.id_txt.text = currentItem.categories_type
        holder.itemView.title_txt.text = currentItem.name

        holder.itemView.rowLayout.setOnClickListener {
            listener.onItemClick(currentItem.name,position)
        }

    }

    fun setData(categories: List<CategoriesEntity>){
        this.categoriesList = categories
        notifyDataSetChanged()
    }

}