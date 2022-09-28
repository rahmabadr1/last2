package com.iittii.last.presentation.quotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iittii.last.model.FoodRecipe
import com.iittii.last.repository.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QutoseViewModel :ViewModel() {
    val qoutoseRepo=Repo()
    val qoutesLiveData= MutableLiveData<FoodRecipe>()
    fun getQuotes(){
        viewModelScope.launch(Dispatchers.Main) {
            qoutoseRepo.getRecipes()?.let{
                qoutesLiveData.value= it
            }
        }
    }
}