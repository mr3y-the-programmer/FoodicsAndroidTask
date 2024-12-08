package com.example.foodicsandroidtask.data

import com.example.foodicsandroidtask.data.local.dao.ProductCategoriesDAO
import com.example.foodicsandroidtask.data.local.toCategory
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
        if (categories != null) {
            dao.insertCategories(categories.map { it.toEntity() })
            return categories
        } else {
            return dao.getAllCategories().map { it.toCategory() }
        }
    }

    suspend fun getProductsBy(categoryId: String, prefix: String? = null): List<Product> {
        val products = apiClient.getProductsByCategory(categoryId)
        if (products != null) {
            dao.insertProducts(products.map { it.toEntity() })

            return if (!prefix.isNullOrBlank()) {
                dao.getProductsByName(prefix).map { it.toProduct() }
            } else {
                products
            }

        } else {
            return if (!prefix.isNullOrBlank()) {
                dao.getProductsByName(prefix).map { it.toProduct() }
            } else {
                dao.getAllProducts().map { it.toProduct() }
            }
        }
    }
}
