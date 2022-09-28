package com.iittii.last.repository

import com.iittii.last.model.FoodRecipe
import com.iittii.last.datasource.remote.RetrofitConfig
import retrofit2.Response
class Repo {
    private val apiService by lazy { RetrofitConfig.getServiceInstance() }

    suspend fun getRecipes(query: HashMap<String, String>): Response<FoodRecipe> =
        apiService.fetchRecipes(query)


}