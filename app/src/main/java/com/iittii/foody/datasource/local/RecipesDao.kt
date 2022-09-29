package com.iittii.last.datasource.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipesEntity: RecipesEntity): Long

    @Delete
    suspend fun deleteRecipe(recipesEntity: RecipesEntity)

    @Query("SELECT * FROM recipes_table")
    fun readRecipes(): Flow<List<RecipesEntity>>
}