package com.example.foodicsandroidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import com.example.foodicsandroidtask.di.appModule
import com.example.foodicsandroidtask.ui.screens.HomeScreen
import com.example.foodicsandroidtask.ui.theme.FoodicsAndroidTaskTheme
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodicsAndroidTaskTheme {
                // Setup coil image loader for loading images from network.
                setSingletonImageLoaderFactory { context ->
                    createAsyncImageLoader(context)
                }
                KoinApplication(
                    application = {
                        modules(appModule)
                    }
                ) {
                    HomeScreen(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

private fun createAsyncImageLoader(context: PlatformContext): ImageLoader {
    return ImageLoader.Builder(context)
        .crossfade(true)
        .build()
}
