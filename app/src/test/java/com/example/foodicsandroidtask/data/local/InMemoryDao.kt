package com.example.foodicsandroidtask.data.local

import com.example.foodicsandroidtask.data.local.dao.ProductCategoriesDAO
import com.example.foodicsandroidtask.data.local.entity.CategoryEntity
import com.example.foodicsandroidtask.data.local.entity.ProductEntity

/**
 * Fake Dao implementation that stores data in memory instead of on disk to help in testing.
 */
class InMemoryDao : ProductCategoriesDAO {

    private val allProducts = mutableSetOf<ProductEntity>()
    private val allCategories = mutableSetOf<CategoryEntity>()

    override suspend fun insertProducts(products: List<ProductEntity>) {
        allProducts.addAll(products)
    }

    override suspend fun insertCategories(categories: List<CategoryEntity>) {
        allCategories.addAll(categories)
    }

    override suspend fun getAllCategories(): List<CategoryEntity> {
        return allCategories.toList()
    }

    override suspend fun getAllProducts(): List<ProductEntity> {
        return allProducts.toList()
    }

    override suspend fun getProductsByName(name: String): List<ProductEntity> {
        return allProducts.filter { it.name.startsWith(name, ignoreCase = true) }
    }

    override suspend fun getProductsByCategory(categoryId: String): List<ProductEntity> {
        return allProducts.filter { it.categoryId == categoryId }
    }
}
