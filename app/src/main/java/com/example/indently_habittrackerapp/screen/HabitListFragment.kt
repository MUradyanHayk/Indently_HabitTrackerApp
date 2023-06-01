package com.example.indently_habittrackerapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.indently_habittrackerapp.R
import com.example.indently_habittrackerapp.databinding.FragmentHabitListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HabitListFragment : Fragment() {
    private lateinit var binding: FragmentHabitListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHabitListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_habitListFragment_to_createHabitFragment)
        }

        binding
    }
}