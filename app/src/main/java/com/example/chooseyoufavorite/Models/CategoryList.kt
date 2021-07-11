package com.example.chooseyoufavorite.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryList(
    val category_id: Int = 1,
    val category: String = "movie",
    val name: String = "Top 250",
    val backdrop_path: String? = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hUwvcDAZG0nbVQokqZh1oQt8Cpm.jpg",
    val overview_of_list: String? = "List of 250 top movies"
) : Parcelable


fun getCategoryList(): List<CategoryList> {
    return listOf(
        CategoryList(1, "movie", "Top 250", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hUwvcDAZG0nbVQokqZh1oQt8Cpm.jpg", "2"),
        CategoryList(2, "movie", "Top 3", "1", "2"),
        CategoryList(3, "movie", "Top 4", "1", "2")
    )
}

fun getCategoryListMusic(): List<CategoryList> {
    return listOf(
        CategoryList(4, "music", "Top 5", "1", "2")
    )
}

