package com.example.jalsanchay

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.jalsanchay.database.AppDatabase
import com.example.jalsanchay.database.Rainfall
import com.example.jalsanchay.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(this)

        loadTotalSavings()

        binding.btnCalculate.setOnClickListener {

            val roofAreaText = binding.etRoofArea.text.toString()
            val tankText = binding.etTankCapacity.text.toString()
            val rainfallText = binding.etRainfall.text.toString()

            if (roofAreaText.isEmpty() ||
                tankText.isEmpty() ||
                rainfallText.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Enter all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            try {

                val roofArea = roofAreaText.toDouble()
                val tankCapacity = tankText.toDouble()
                val rainfall = rainfallText.toDouble()

                val collectedWater = roofArea * rainfall * 0.8

                val filledWater =
                    if (collectedWater > tankCapacity)
                        tankCapacity
                    else
                        collectedWater

                binding.tvResult.text =
                    "Collected Water: %.2f Litres".format(filledWater)

            } catch (e: Exception) {

                Toast.makeText(
                    this,
                    "Invalid Input",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun loadTotalSavings() {

    }
}