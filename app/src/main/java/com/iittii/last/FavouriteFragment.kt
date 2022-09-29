package com.iittii.last

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.iittii.last.adapter.OnClickInterface
import com.iittii.last.adapter.RecipesAdapter
import com.iittii.last.databinding.FragmentRecipesBinding
import com.iittii.last.datasource.local.entityToResult
import com.iittii.last.model.Result
import com.iittii.last.presentation.quotes.RecipeViewModel

class FavouriteFragment : Fragment(){

    private lateinit var adaptar: RecipesAdapter
    private lateinit var binding: FragmentRecipesBinding
    private lateinit var viewModel: RecipeViewModel
    private lateinit var searchView: SearchView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipesBinding.inflate(inflater)

        viewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        setuprv()
        getFavouriteRecipes()

        return binding.root
    }

    private fun setuprv() {
        adaptar = RecipesAdapter(object : OnClickInterface {
            override fun onClick(result: Result) {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.containerB, RecipeDetailsFragment().apply { detail = result })
                    ?.addToBackStack(null)?.commit()
            }

            override fun onFavouriteClicked(isFav: Boolean, result: Result) {
                if(isFav) {
                    viewModel.insertRecipe(result)
                    getFavouriteRecipes()
                }else{
                    viewModel.deleteRecipe(result)
                    getFavouriteRecipes()
                }
            }
        })
        val linearlayoutmanager = LinearLayoutManager(context)
        binding.recipeRv.layoutManager = linearlayoutmanager
        binding.recipeRv.addItemDecoration(
            DividerItemDecoration(
                context,
                linearlayoutmanager.orientation
            )
        )
        binding.recipeRv.adapter = adaptar
    }


    private fun getFavouriteRecipes() {
        viewModel.getFavouriteRecipes().observe(viewLifecycleOwner) {
            val recipeList = it.map {
                entityToResult(it)
            }

            val favIdList = recipeList.map { it.id }

            adaptar.setData(recipeList)
            adaptar.setFav(favIdList)
        }
    }
}