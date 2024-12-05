package com.example.foodicsandroidtask.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
    foreignKeys = [ForeignKey(entity = CategoryEntity::class, parentColumns = ["id"], childColumns = ["categoryId"])]
)
data class ProductEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String?,
    val price: Double,
    val imageUrl: String,
    @ColumnInfo(name = "categoryId", index = true)
    val categoryId: String,
    val categoryName: String
)
