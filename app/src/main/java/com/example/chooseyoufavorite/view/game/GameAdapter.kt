package com.example.chooseyoufavorite.view.game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.data.room.categories.movies.top250Movies.Top250MoviesEntity
import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesEntity
import com.example.chooseyoufavorite.view.categories.CategoriesAdapter
import kotlinx.android.synthetic.main.fragment_categories_item.view.*
import java.util.*

class GameAdapter: RecyclerView.Adapter<GameAdapter.MyViewHolder>() {

    private var cardsList = emptyList<Top250MoviesEntity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_game_item, parent, false)
        )
    }

    override fun getItemCount() = cardsList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = cardsList[position]
        holder.itemView.id_txt.text = currentItem.cinemaId.toString()
        holder.itemView.title_txt.text = currentItem.title
    }

    fun setData(cards: List<Top250MoviesEntity>){
        this.cardsList = cards
        notifyDataSetChanged()
    }

}