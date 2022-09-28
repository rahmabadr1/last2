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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QutoseViewModel :ViewModel() {
    val qoutoseRepo=Repo()
    val qoutesLiveData= MutableLiveData<FoodRecipe>()
    fun getQuotes(){
        viewModelScope.launch(Dispatchers.Main) {
            qoutoseRepo.getRecipes(applyQueries())?.let{
                qoutesLiveData.value= it
            }
        }
    }

    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()
        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }
}