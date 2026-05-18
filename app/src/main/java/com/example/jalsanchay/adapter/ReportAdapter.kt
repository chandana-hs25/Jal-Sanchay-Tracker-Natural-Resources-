package com.example.jalsanchay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jalsanchay.R
import com.example.jalsanchay.database.Rainfall

class ReportAdapter(private val list: List<Rainfall>) :
    RecyclerView.Adapter<ReportAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvData: TextView = view.findViewById(R.id.tvData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_report, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.tvData.text =
            "Date: ${item.date}\nRainfall: ${item.rainfall} mm\nSaved: ${item.litersSaved} L"
    }
}