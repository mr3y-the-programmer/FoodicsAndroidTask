package com.example.foodicsandroidtask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodicsandroidtask.data.local.dao.ProductCategoriesDAO
import com.example.foodicsandroidtask.data.local.entity.CategoryEntity
import com.example.foodicsandroidtask.data.local.entity.ProductEntity

@Database(version = 1, entities = [ProductEntity::class, CategoryEntity::class], exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productCategoriesDao(): ProductCategoriesDAO
}
