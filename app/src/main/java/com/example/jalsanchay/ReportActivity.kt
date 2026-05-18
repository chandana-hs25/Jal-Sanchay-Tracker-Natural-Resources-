package com.example.jalsanchay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jalsanchay.adapter.ReportAdapter
import com.example.jalsanchay.database.AppDatabase
import com.example.jalsanchay.databinding.ActivityReportBinding
import kotlinx.coroutines.launch

class ReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val db = AppDatabase.getDatabase(this)

        lifecycleScope.launch {

            val data = db.rainfallDao().getAllRainfall()

            binding.recyclerView.adapter = ReportAdapter(data)
        }
    }
}