package com.example.indently_habittrackerapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.indently_habittrackerapp.R
import com.example.indently_habittrackerapp.databinding.FragmentCreateHabitBinding
import dagger.hilt.EntryPoint

@EntryPoint
class CreateHabitFragment : Fragment() {
    private lateinit var binding: FragmentCreateHabitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateHabitBinding.inflate(inflater, container, false)
        return binding.root
    }
}