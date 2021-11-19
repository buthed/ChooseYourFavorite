package com.example.chooseyoufavorite.data.room.categories

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoriesEntity(@PrimaryKey(autoGenerate = true) val id:Int,
                            val categories_type: String,
                            val name: String)
