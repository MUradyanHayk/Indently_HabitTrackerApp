package com.example.indently_habittrackerapp.di.module

import com.example.indently_habittrackerapp.data.dao.HabitDao
import com.example.indently_habittrackerapp.data.database.HabitDatabase
import com.example.indently_habittrackerapp.data.repository.HabitRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun provideHabitRepository(dao: HabitDao): HabitRepository {
        return HabitRepository(dao)
    }
}