package com.example.testappandoid.model_3

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.Comunication
import com.example.testappandoid.databinding.Model3Binding
import com.example.testappandoid.model.Structure

class MyAdapter3 (private val donnerALL: Structure,var comunication: Comunication) : RecyclerView.Adapter<MyHolder3>() {
    private lateinit var binding : Model3Binding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder3 {
        binding = Model3Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        Log.println(Log.INFO,"savoir si sa passe","savoir si sa passe")
        if (comunication != null){
            Log.println(Log.INFO,"existe", true.toString())
        }
        return MyHolder3(binding,comunication)
    }

    override fun getItemCount(): Int = donnerALL.Donner.size/3

    override fun onBindViewHolder(holder: MyHolder3, position: Int) {
        holder.bind(donnerALL.Donner.get(position),donnerALL.Donner.get(position + (donnerALL.Donner.size/3)),donnerALL.Donner.get(position + (donnerALL.Donner.size/3) + (donnerALL.Donner.size/3)))
    }


}