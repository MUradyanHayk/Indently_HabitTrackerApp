package com.example.indently_habittrackerapp.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.indently_habittrackerapp.databinding.FragmentUpdateHabitBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateHabitFragment : Fragment() {
    private lateinit var binding: FragmentUpdateHabitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUpdateHabitBinding.inflate(inflater, container, false)
        return binding.root
    }
}