package com.example.et

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter(val data: List<ResultsItem>): RecyclerView.Adapter<Adapter.MyViewHolder>() {
    class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val height = view.findViewById<TextView>(R.id.height)
        val birthYear = view.findViewById<TextView>(R.id.birth_year)
        val gender = view.findViewById<TextView>(R.id.gender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(data != null){
            return data.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = data?.get(position)?.name
        holder.height.text = data?.get(position)?.height
        holder.birthYear.text = data?.get(position)?.birthYear
        holder.gender.text = data?.get(position)?.gender

        //holder.itemView.setOnClickListener{
          //  val name = data?.get(position)?.name
            //Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        //}
    }
}