package com.example.indently_habittrackerapp.data.repository

import androidx.lifecycle.LiveData
import com.example.indently_habittrackerapp.data.dao.HabitDao
import com.example.indently_habittrackerapp.data.database.HabitDatabase
import com.example.indently_habittrackerapp.data.model.HabitModel
import javax.inject.Inject

class HabitRepository @Inject constructor(private val dao: HabitDao) {

    suspend fun addHabit(habit: HabitModel) {
        dao.addHabit(habit)
    }

    suspend fun updateHabit(habit: HabitModel) {
        dao.updateHabit(habit)
    }

    suspend fun deleteHabit(habit: HabitModel) {
        dao.deleteHabit(habit)
    }

    suspend fun deleteAllHabits() {
        dao.deleteAllHabits()
    }

    suspend fun getAllHabits(): List<HabitModel> {
        return dao.getAllHabits()
    }
}