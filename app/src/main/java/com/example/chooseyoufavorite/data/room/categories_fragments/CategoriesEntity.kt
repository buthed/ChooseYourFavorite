package com.example.chooseyoufavorite.data.room.categories_fragments

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "categories",
    foreignKeys = [ForeignKey(
        entity = CategoriesTypeEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categories_type")
    )])
data class CategoriesEntity(@PrimaryKey(autoGenerate = true) val id:Int,
                            @ColumnInfo(name = "categories_type") val categories_type: String,
                            @ColumnInfo(name = "categories_id") val categoriesId: String,
                            @ColumnInfo(name = "name") val name: String)

