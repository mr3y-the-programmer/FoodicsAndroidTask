package com.example.foodicsandroidtask.data.local

import com.example.foodicsandroidtask.data.local.entity.CategoryEntity
import com.example.foodicsandroidtask.data.local.entity.ProductEntity
import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product

fun CategoryEntity.toCategory() = Category(id, name)

fun Category.toEntity() = CategoryEntity(id, name)

fun ProductEntity.toProduct() = Product(
    id = id,
    name = name,
    description = description,
    price = price,
    image = imageUrl,
    category = Category(categoryId, categoryName)
)

fun Product.toEntity() = ProductEntity(
    id = id,
    name = name,
    description = description,
    price = price,
    imageUrl = image,
    categoryId = category.id,
    categoryName = category.name
)
