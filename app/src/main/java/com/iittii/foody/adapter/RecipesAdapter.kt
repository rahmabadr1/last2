package com.iittii.last.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iittii.last.R
import com.iittii.last.databinding.RecipesRowLayoutBinding
import com.iittii.last.model.Result
import com.squareup.picasso.Picasso

class RecipesAdapter(private val onClickInterface: OnClickInterface) :
    RecyclerView.Adapter<RecipesAdapter.RecipesHolder>() {

    private var recipes = emptyList<Result>()
    private var favList = emptyList<Int>()

    inner class RecipesHolder(private val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result) {
            Picasso.get().load(result.image).into(binding.recipeImage)
            binding.recipeTextView.text = result.title
            binding.likesTextView.text = result.aggregateLikes.toString()
            binding.clockTextView.text = result.readyInMinutes.toString()
            binding.leafTextView.text = result.vegan.toString()

            if (favList.contains(result.id))
                binding.favImage.setImageResource(R.drawable.ic_favorite)
            else
                binding.favImage.setImageResource(R.drawable.ic_not_favorite)

            binding.root.setOnClickListener {
                onClickInterface.onClick(result)
            }
            binding.favBtn.setOnClickListener {
                onClickInterface.onFavouriteClicked(!favList.contains(result.id), result)
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

    fun setData(data: List<Result>) {
        recipes = data
        notifyDataSetChanged()
    }

    fun setFav(data: List<Int>) {
        favList = data
        notifyDataSetChanged()
    }
}