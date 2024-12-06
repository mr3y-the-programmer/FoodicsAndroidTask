package com.example.foodicsandroidtask.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val name: String,
    val description: String?,
    val image: String,
    val price: Double,
    val category: Category
)
