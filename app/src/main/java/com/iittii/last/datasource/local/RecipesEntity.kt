package com.iittii.last.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iittii.last.util.Constants.RECIPE_TABLE

@Entity(tableName = RECIPE_TABLE)
class RecipesEntity(
    val aggregateLikes: Int,
    val cheap: Boolean,
    val dairyFree: Boolean,
    val glutenFree: Boolean,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val readyInMinutes: Int,
    val summary: String,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean
)

