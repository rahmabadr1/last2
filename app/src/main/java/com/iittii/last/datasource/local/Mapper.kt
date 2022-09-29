package com.iittii.last.datasource.local

import com.iittii.last.model.Result

fun resultToEntity(result: Result): RecipesEntity {
    return RecipesEntity(
        result.aggregateLikes,
        result.cheap,
        result.dairyFree,
        result.glutenFree,
        result.id,
        result.image,
        result.readyInMinutes,
        result.summary,
        result.title,
        result.vegan,
        result.vegetarian,
        result.veryHealthy
    )
}

fun entityToResult(entity: RecipesEntity): Result {
    return Result(
        entity.aggregateLikes,
        entity.cheap,
        entity.dairyFree,
        entity.glutenFree,
        entity.id,
        entity.image,
        entity.readyInMinutes,
        entity.summary,
        entity.title,
        entity.vegan,
        entity.vegetarian,
        entity.veryHealthy,
        null,
        null,
        null
    )
}
