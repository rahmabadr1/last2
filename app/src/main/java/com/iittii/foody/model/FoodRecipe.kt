package com.iittii.foody.model

import java.io.Serializable

data class FoodRecipe(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)

data class ExtendedIngredients(
    val amount: Double,
    val consistency: String,
    val image: String,
    val name: String,
    val original: String,
    val unit: String
) : Serializable

data class Result(
    val aggregateLikes: Int,
    val cheap: Boolean,
    val dairyFree: Boolean,
    val glutenFree: Boolean,
    val id: Int,
    val image: String,
    val readyInMinutes: Int,
    val summary: String,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val extendedIngredients: List<ExtendedIngredients>?,
    val sourceName: String?,
    val sourceUrl: String?,
) : Serializable