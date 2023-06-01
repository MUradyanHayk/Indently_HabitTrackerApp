package com.example.indently_habittrackerapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.indently_habittrackerapp.data.dao.HabitDao
import com.example.indently_habittrackerapp.data.model.HabitModel

@Database(entities = [HabitModel::class], version = 1)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}