package com.example.foodicsandroidtask.data

import com.example.foodicsandroidtask.data.network.ApiClient
import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product

class Repository(
    private val apiClient: ApiClient
) {

    suspend fun getAllCategories(): List<Category> {
        return apiClient.getCategories()
    }

    suspend fun getProductsBy(categoryId: String, prefix: String? = null): List<Product> {
        return apiClient.getProductsByCategory(categoryId)
            .run {
                if (!prefix.isNullOrBlank()) {
                    filter { it.name.startsWith(prefix, ignoreCase = true) }
                } else {
                    this
                }
            }
    }
}
