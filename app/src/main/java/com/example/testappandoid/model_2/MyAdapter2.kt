package com.example.testappandoid.model_2

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.databinding.Model2Binding
import com.example.testappandoid.model.Structure

class MyAdapter2 (private val donnerALL: Structure) : RecyclerView.Adapter<MyHolder2>() {
    private lateinit var binding : Model2Binding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder2 {
        binding = Model2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        Log.println(Log.INFO,"savoir si sa passe","savoir si sa passe")

        return MyHolder2(binding)
    }

    override fun getItemCount(): Int = donnerALL.Donner.size/2

    override fun onBindViewHolder(holder: MyHolder2, position: Int) {
        holder.bind(donnerALL.Donner.get(position),donnerALL.Donner.get(position + (donnerALL.Donner.size/2)))
    }


}