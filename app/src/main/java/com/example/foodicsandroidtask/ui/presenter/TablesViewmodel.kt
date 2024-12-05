package com.example.foodicsandroidtask.ui.presenter

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodicsandroidtask.data.Repository
import com.example.foodicsandroidtask.model.Product
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

@OptIn(FlowPreview::class)
class TablesViewmodel(
    private val repository: Repository
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    private val _state = MutableStateFlow(TablesUiState.Default)
    val state = _state.asStateFlow()

    init {
        val allCategories = repository.getAllCategories()
        val selectedCategory = allCategories[_state.value.selectedCategoryIndex]
        val products = repository.getProductsBy(categoryId = selectedCategory.id)
        _state.update {
            it.copy(
                allCategories = allCategories,
                allProducts = products
            )
        }

        snapshotFlow { _searchQuery.value }
            .dropWhile { it.isBlank() } // drop initial empty or blank values
            .debounce(250) // avoid redundant intermediate requests when user is typing so fast.
            .onEach { searchQuery ->
                val categoryId = _state.value.allCategories[_state.value.selectedCategoryIndex].id
                val searchResult = repository.getProductsBy(categoryId = categoryId, prefix = searchQuery)
                _state.update { state -> state.copy(allProducts = searchResult) }
            }
            .launchIn(viewModelScope)
    }

    fun updateSearchQuery(newSearchQuery: String) {
        _searchQuery.value = newSearchQuery
        _state.update { it.copy(searchQuery = newSearchQuery) }
    }

    fun selectCategory(categoryIndex: Int) {
        _state.update { it.copy(selectedCategoryIndex = categoryIndex) }
    }

    fun addProductToOrder(product: Product) {
        _state.update { it.copy(orderProducts = it.orderProducts + product) }
    }

    fun clearOrder() {
        _state.update { it.copy(orderProducts = emptyList()) }
    }
}
