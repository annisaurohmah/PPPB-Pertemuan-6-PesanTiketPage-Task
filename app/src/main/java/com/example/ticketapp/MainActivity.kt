package com.example.ticketapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ticketapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val types = resources.getStringArray(R.array.types)
        val cities = resources.getStringArray(R.array.cities)
        val classes = resources.getStringArray(R.array.classes)
        val people = resources.getStringArray(R.array.people)
        
        with(binding) {
            val typesAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, types
            )
            typesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinTypes.adapter = typesAdapter

            val citiesAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cities
            )
            citiesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinCitiesDari.adapter = citiesAdapter
            spinCitiesKe.adapter= citiesAdapter

            val peopleAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, people
            )
            peopleAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinPeople.adapter = peopleAdapter

            val classAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, classes
            )
            classAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinClasses.adapter = classAdapter

            var selectedDate = ""
            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year " }

            var selectedTime = ""
            pickerTime.setOnTimeChangedListener { _, hourOfDay, minutes ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minutes)
            }
            btnPesan.setOnClickListener {
                Toast.makeText(this@MainActivity, "Tiket untuk " +
                "tanggal " + selectedDate + "pukul " + selectedTime + " berhasil dipesan!", Toast.LENGTH_LONG).show()
            }

        }
    }
}