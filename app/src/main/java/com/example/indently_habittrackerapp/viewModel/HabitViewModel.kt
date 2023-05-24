package com.example.indently_habittrackerapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indently_habittrackerapp.data.model.HabitModel
import com.example.indently_habittrackerapp.data.repository.HabitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(val repository: HabitRepository) : ViewModel() {
    val allHabits: MutableLiveData<List<HabitModel>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            allHabits.postValue(repository.getAllHabits())
        }
    }

    fun addHabit(habit: HabitModel) {
        viewModelScope.launch {
            repository.addHabit(habit)
        }
    }

    fun updateHabit(habit: HabitModel) {
        viewModelScope.launch {
            repository.updateHabit(habit)
        }
    }

    fun deleteHabit(habit: HabitModel) {
        viewModelScope.launch {
            repository.deleteHabit(habit)
        }
    }

    fun deleteAllHabits() {
        viewModelScope.launch {
            repository.deleteAllHabits()
        }
    }
}