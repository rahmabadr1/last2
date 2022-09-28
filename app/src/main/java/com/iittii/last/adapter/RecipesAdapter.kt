package com.iittii.last.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iittii.last.databinding.RecipesRowLayoutBinding
import com.iittii.last.model.FoodRecipe
import com.iittii.last.model.Result
import com.iittii.task5.util.Constants
import com.squareup.picasso.Picasso

 class RecipesAdapter(private val onClickInterface: OnClickInterface)  :
    RecyclerView.Adapter<RecipesAdapter.RecipesHolder>() {

    private var recipes = emptyList<Result>()

    inner class RecipesHolder(private val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result) {
            Picasso.get().load(Constants.BASE_IMAGE_URL + result.image).into(binding.recipeImage)

            binding.root.setOnClickListener {
                onClickInterface.onClick(result)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
        return RecipesHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipesHolder, position: Int) {
        val data = recipes[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = recipes.size

    fun setData(data: FoodRecipe) {
        recipes = data.results
        notifyDataSetChanged()
    }
}