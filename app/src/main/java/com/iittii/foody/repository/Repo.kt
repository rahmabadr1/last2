package com.iittii.last.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.iittii.last.RecipeApp
import com.iittii.last.datasource.local.RecipesEntity
import com.iittii.last.datasource.local.resultToEntity
import com.iittii.last.datasource.remote.RetrofitConfig
import com.iittii.last.model.FoodRecipe
import com.iittii.last.model.Result
import kotlinx.coroutines.flow.first
import kotlin.math.log

class Repo {
    private val apiService by lazy { RetrofitConfig.getServiceInstance() }
    private val recipeDao by lazy { RecipeApp.recipeDao }

    suspend fun getRecipes(query: HashMap<String, String>): FoodRecipe? {
        val response = apiService.fetchRecipes(query)
        return if (response.isSuccessful && response.code() == 200) {
            response.body()
        } else {
            null
        }
    }

    suspend fun saveRecipe(result: Result){
        val rr = recipeDao.insertRecipe(resultToEntity(result))
        Log.d("TAG", "saveRecipe: $rr")
    }

    suspend fun deleteRecipe(result: Result){
        recipeDao.deleteRecipe(resultToEntity(result))
    }

    fun getFavouriteRecipes(): LiveData<List<RecipesEntity>> =
        recipeDao.readRecipes().asLiveData()


}