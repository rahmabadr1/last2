package com.iittii.last.repository

import com.iittii.last.model.FoodRecipe
import com.iittii.last.datasource.remote.RetrofitConfig
import retrofit2.Response
class Repo {
    private val apiService by lazy { RetrofitConfig.getServiceInstance() }

    suspend fun getRecipes(query: HashMap<String, String>): FoodRecipe? {
        val response = apiService.fetchRecipes(query)
        if (response.isSuccessful && response.code() == 200){
            return response.body()
        }else{
            return null
        }
    }

}