package com.example.indently_habittrackerapp.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.indently_habittrackerapp.data.dao.HabitDao
import com.example.indently_habittrackerapp.data.database.HabitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object HabitDatabaseModule {
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): HabitDatabase {
        return Room.databaseBuilder(context, HabitDatabase::class.java, "habit_db").build()
    }

    @Provides
    fun provideHabitDao(db: HabitDatabase): HabitDao {
        return db.habitDao()
    }
}