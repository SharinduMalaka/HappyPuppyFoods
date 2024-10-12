package com.example.HappyPuppyFoods

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.jetbrains.annotations.Nullable

@Dao
interface Dao {

    @Query("SELECT * FROM recipe")
    @Nullable
    fun getAll(): List<Recipe>?

    @Insert
    fun setAll(recipes: List<Recipe>?)
}
