package com.example.foodicsandroidtask.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foodicsandroidtask.data.local.dao.ProductCategoriesDAO
import com.example.foodicsandroidtask.model.SampleCategories
import com.example.foodicsandroidtask.model.SampleProducts
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseOperationsTest {

    private lateinit var dao: ProductCategoriesDAO
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.productCategoriesDao()
    }

    @Test
    fun writeSomeDataToDaoAndReadIt() = runTest {
        dao.insertCategories(SampleCategories.map { it.toEntity() })
        dao.insertProducts(SampleProducts.map { it.toEntity() })

        val actualCategories = dao.getAllCategories().map { it.toCategory() }
        val actualProducts = dao.getAllProducts().map { it.toProduct() }
        assertThat(actualCategories, equalTo(SampleCategories))
        assertThat(actualProducts, equalTo(SampleProducts))
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}
