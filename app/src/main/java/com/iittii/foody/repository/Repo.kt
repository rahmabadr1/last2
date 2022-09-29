package com.iittii.foody.repository

import android.util.Log
import com.iittii.foody.datasource.remote.RetrofitConfig
import com.iittii.foody.model.FoodRecipe

class Repo {
    private val apiService by lazy { RetrofitConfig.getServiceInstance() }

    suspend fun getRecipes(query: HashMap<String, String>): FoodRecipe? {
        try {
            val response = apiService.fetchRecipes(query)
            Log.d("TAG", "getRecipes: 1")
            if (response.isSuccessful && response.code() == 200) {
                return response.body()
                Log.d("TAG", "getRecipes: 1")
            } else {
                Log.d("TAG", "getRecipes: 2")
                Log.d("TAG", "getRecipes: ${response.isSuccessful}")
                Log.d("TAG", "getRecipes: ${response.code()}")
                return null
            }
        } catch (e: Exception) {
            Log.d("TAG", "getRecipes: $e")
            return null
        }}


    }