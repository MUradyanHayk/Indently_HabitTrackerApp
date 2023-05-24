package com.example.indently_habittrackerapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.indently_habittrackerapp.data.model.HabitModel

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHabit(habitModel: HabitModel)

    @Update
    suspend fun updateHabit(habitModel: HabitModel)

    @Delete
    suspend fun deleteHabit(habitModel: HabitModel)

    @Query("SELECT * FROM habit_table ORDER BY id DESC")
    suspend fun getAllHabits(): List<HabitModel>


    @Query("DELETE FROM habit_table")
    suspend fun deleteAllHabits()
}