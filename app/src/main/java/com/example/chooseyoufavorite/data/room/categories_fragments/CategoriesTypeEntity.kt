package com.example.chooseyoufavorite.data.room.categories_fragments

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_type")
data class CategoriesTypeEntity(@PrimaryKey(autoGenerate = true) val id:Int,
                                @ColumnInfo(name = "type_of_category") val type_of_category: String)
