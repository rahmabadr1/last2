package com.iittii.last.repo

import com.iittii.last.model.FoodRecipe
import com.iittii.last.remote.RetrofitConfig
import retrofit2.Response

class Repo {
    private val apiService by lazy { RetrofitConfig.getServiceInstance() }

    suspend fun getRecipes(query: HashMap<String, String>): Response<FoodRecipe> =
        apiService.fetchRecipes(query)
}