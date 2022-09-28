package com.iittii.last.presentation.quotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iittii.last.model.FoodRecipe
import com.iittii.last.repository.Repo
import com.iittii.last.util.Constants.API_KEY
import com.iittii.last.util.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.iittii.last.util.Constants.QUERY_API_KEY
import com.iittii.last.util.Constants.QUERY_FILL_INGREDIENTS
import com.iittii.last.util.Constants.QUERY_NUMBER
import com.iittii.last.util.Constants.QUERY_SEARCH
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel :ViewModel() {
    private val qoutoseRepo=Repo()
    val qoutesLiveData= MutableLiveData<FoodRecipe>()

    fun getRecipes(searchQuery: String? = null){
        viewModelScope.launch(Dispatchers.Main) {
            qoutoseRepo.getRecipes(applyQueries(searchQuery))?.let{
                qoutesLiveData.value= it
            }
        }
    }

    private fun applyQueries(searchQuery: String? = null): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()
        searchQuery?.let { queries[QUERY_SEARCH] = searchQuery }
        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }
}