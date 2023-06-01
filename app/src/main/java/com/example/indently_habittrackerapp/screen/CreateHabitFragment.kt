package com.example.indently_habittrackerapp.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.indently_habittrackerapp.R
import com.example.indently_habittrackerapp.data.model.HabitModel
import com.example.indently_habittrackerapp.databinding.FragmentCreateHabitBinding
import com.example.indently_habittrackerapp.utils.CalculationsUtils
import com.example.indently_habittrackerapp.viewModel.HabitViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class CreateHabitFragment : Fragment(), TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private lateinit var binding: FragmentCreateHabitBinding

    private var title = ""
    private var description = ""
    private var drawableSelected = 0
    private var timeStamp = ""

    private var day = 0
    private var month = 0
    private var year = 0
    private var hour = 0
    private var minute = 0

    private var cleanDate = ""
    private var cleanTime = ""

    private val habitViewModel: HabitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateHabitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConfirm.setOnClickListener {
            addHabitToDB()
        }
        pickDateAndTime()
        onDrawableSelected()
    }

    private fun addHabitToDB() {
        title = binding.etHabitTitle.text.toString()
        description = binding.etHabitDescription.text.toString()

        timeStamp = "$cleanDate $cleanTime"
        if (!(title.isEmpty() || description.isEmpty()) || !(timeStamp.isEmpty() || drawableSelected == 0)) {
            val habit = HabitModel(0, title, description, timeStamp, drawableSelected)
            habitViewModel.addHabit(habit)
            findNavController().navigate(R.id.action_createHabitFragment_to_habitListFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill ....", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onDrawableSelected() {
        binding.ivFastFoodSelected.setOnClickListener {
            binding.ivFastFoodSelected.isSelected = !binding.ivFastFoodSelected.isSelected
            drawableSelected = R.drawable.ic_fill_fastfood
            binding.ivSmokingSelected.isSelected = false
            binding.ivTeaSelected.isSelected = false
        }

        binding.ivSmokingSelected.setOnClickListener {
            binding.ivSmokingSelected.isSelected = !binding.ivSmokingSelected.isSelected
            drawableSelected = R.drawable.ic_fill_smoking
            binding.ivTeaSelected.isSelected = false
            binding.ivFastFoodSelected.isSelected = false
        }

        binding.ivTeaSelected.setOnClickListener {
            binding.ivTeaSelected.isSelected = !binding.ivTeaSelected.isSelected
            drawableSelected = R.drawable.ic_fill_tea
            binding.ivSmokingSelected.isSelected = false
            binding.ivFastFoodSelected.isSelected = false
        }
    }

    private fun pickDateAndTime() {
        binding.btnPickDate.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()
        }

        binding.btnPickTime.setOnClickListener {
            getTimeCalendar()
            TimePickerDialog(requireContext(), this, hour, minute, true).show()
        }
    }

    private fun getTimeCalendar() {
        val cal = Calendar.getInstance()
        hour = cal.get(Calendar.HOUR_OF_DAY)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        cleanTime = CalculationsUtils.cleanDate(hourOfDay, minute)
        binding.tvTimeSelected.text = "Time: $cleanTime"
    }

    override fun onDateSet(p0: DatePicker?, yearX: Int, monthX: Int, dayX: Int) {
        cleanDate = CalculationsUtils.cleanDate(dayX, monthX, yearX)
        binding.tvDateSelected.text = "Time: $cleanDate"
    }
}