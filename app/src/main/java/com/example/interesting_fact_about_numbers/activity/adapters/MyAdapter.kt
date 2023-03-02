package com.example.interesting_fact_about_numbers.activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interesting_fact_about_numbers.R
import com.example.interesting_fact_about_numbers.db.NumbersFact

class MyAdapter(val dataList: List<NumbersFact>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val textView: TextView = itemView.findViewById(R.id.tvtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList.get(holder.adapterPosition)
        holder.textView.text = data.fact
    }

    override fun getItemCount() = dataList.size

}