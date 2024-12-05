package com.example.foodicsandroidtask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodicsandroidtask.ui.theme.FoodicsAndroidTaskTheme

@Composable
fun PlaceholderScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Text(text = "Placeholder screen", color = MaterialTheme.colorScheme.onBackground)
    }
}

@Preview
@Composable
fun PlaceholderScreenPreview() {
    FoodicsAndroidTaskTheme {
        PlaceholderScreen(modifier = Modifier.fillMaxSize())
    }
}
