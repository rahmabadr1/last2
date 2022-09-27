package com.iittii.last.model

import android.os.Parcelable
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
): Serializable

data class Result(
    val aggregateLikes: Int,
    val cheap: Boolean,
    val dairyFree: Boolean,
    val extendedIngredients: List<ExtendedIngredients>,
    val glutenFree: Boolean,
    val id: Int,
    val image: String,
    val readyInMinutes: Int,
    val sourceName: String?,
    val sourceUrl: String,
    val summary: String,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean
) : Serializable