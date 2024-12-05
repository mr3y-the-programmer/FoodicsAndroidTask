package com.example.foodicsandroidtask.ui.presenter

import androidx.compose.runtime.Stable
import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product

@Stable
data class TablesUiState(
    val allCategories: List<Category>,
    val selectedCategoryIndex: Int,
    val searchQuery: String,
    val allProducts: List<Product>,
    val orderProducts: List<Product>
) {
    companion object {
        val Default = TablesUiState(emptyList(), 0, "", emptyList(), emptyList())
    }
}
