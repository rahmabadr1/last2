package com.iittii.last

import android.app.Application
import androidx.room.Room
import com.iittii.last.datasource.local.RecipesDao
import com.iittii.last.datasource.local.RecipesDatabase

class RecipeApp : Application() {
    private var dao: RecipesDao? = null

    override fun onCreate() {
        super.onCreate()
        if (dao == null) {
            dao = Room.databaseBuilder(applicationContext, RecipesDatabase::class.java, "Recipe")
                .build().recipesDao()
        }

        recipeDao = dao!!
    }

    companion object {
        lateinit var recipeDao: RecipesDao
    }
}