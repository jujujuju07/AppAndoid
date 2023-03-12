package com.example.testappandoid.model_1

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.databinding.Model1Binding
import com.example.testappandoid.model.Structure

class MyAdapter1 (private val donnerALL: Structure) : RecyclerView.Adapter<MyHolder1>() {
    private lateinit var binding : Model1Binding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder1 {
        binding = Model1Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        Log.println(Log.INFO,"Myadapter1","savoir si sa passe")

        return MyHolder1(binding)
    }

    override fun getItemCount(): Int = donnerALL.Donner.size

    override fun onBindViewHolder(holder: MyHolder1, position: Int) {
        holder.bind(donnerALL.Donner.get(position))
    }


}