package com.example.indently_habittrackerapp.di

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
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object HabitDatabaseModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(context, HabitDatabase::class.java, "habit_db").build()
    }

    @Provides
    @Singleton
    fun provideHabitDao(db: HabitDatabase): HabitDao {
        return db.habitDao()
    }
}