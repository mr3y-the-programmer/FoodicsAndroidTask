package com.example.foodicsandroidtask.data

import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product
import com.example.foodicsandroidtask.model.SampleCategories
import com.example.foodicsandroidtask.model.SampleProducts

class Repository {

    private val allProducts = SampleProducts

    fun getAllCategories(): List<Category> {
        return SampleCategories
    }

    fun getProductsBy(categoryId: String, prefix: String? = null): List<Product> {
        return allProducts
            .run {
                if (!prefix.isNullOrBlank()) {
                    filter { it.name.startsWith(prefix, ignoreCase = true) }
                } else {
                    this
                }
            }
    }
}
