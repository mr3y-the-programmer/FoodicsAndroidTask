package com.example.foodicsandroidtask.data

import com.example.foodicsandroidtask.data.local.dao.ProductCategoriesDAO
import com.example.foodicsandroidtask.data.local.toEntity
import com.example.foodicsandroidtask.data.local.toProduct
import com.example.foodicsandroidtask.data.network.ApiClient
import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product

class Repository(
    private val apiClient: ApiClient,
    private val dao: ProductCategoriesDAO
) {

    suspend fun getAllCategories(): List<Category> {
        val categories = apiClient.getCategories()
        dao.insertCategories(categories.map { it.toEntity() })
        return categories
    }

    suspend fun getProductsBy(categoryId: String, prefix: String? = null): List<Product> {
        val products = apiClient.getProductsByCategory(categoryId)
        dao.insertProducts(products.map { it.toEntity() })
        return if (!prefix.isNullOrBlank()) {
            dao.getProductsByName(prefix).map { it.toProduct() }
        } else {
            products
        }
    }
}
