package com.example.et

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class Adapter : ListAdapter<ResultsItem, Adapter.ViewHolder>(ResultsItemDiffCallback()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
        val height = view.findViewById<TextView>(R.id.height)
        val birthYear = view.findViewById<TextView>(R.id.birth_year)
        val gender = view.findViewById<TextView>(R.id.gender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = getItem(position)
        holder.name.text = result.name
        holder.height.text = result.height
        holder.birthYear.text = result.birthYear
        holder.gender.text = result.gender
    }

    private class ResultsItemDiffCallback : DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem == newItem
        }
    }
}
