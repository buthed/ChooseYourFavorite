package com.example.chooseyoufavorite.view.categories

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity
import com.example.chooseyoufavorite.viewmodel.CategoriesTypeViewModel
import kotlinx.android.synthetic.main.fragment_categories_item.view.*


class CategoriesTypeAdapter: RecyclerView.Adapter<CategoriesTypeAdapter.MyViewHolder>() {

    private val TAG = "LOGTYPE"
    private var categoriesList = emptyList<CategoriesTypeEntity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_categories_type_item, parent, false))
    }

    override fun getItemCount() = categoriesList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoriesList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.title_txt.text = currentItem.type_of_category

        holder.itemView.rowLayout.setOnClickListener {
            Log.e(TAG, currentItem.type_of_category)
            holder.itemView.rowLayout.setOnClickListener {
                holder.itemView.findNavController().navigate(
                    R.id.navCategories,
                    bundleOf(CategoriesFragment.categoryKey to currentItem.type_of_category)
                )
            }
        }
    }

    fun setData(categories_type: List<CategoriesTypeEntity>){
        this.categoriesList = categories_type
        notifyDataSetChanged()
    }
}