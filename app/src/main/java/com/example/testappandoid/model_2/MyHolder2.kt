package com.example.testappandoid.model_2

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.databinding.Model2Binding
import com.example.testappandoid.model.Donner


class MyHolder2 (private val binding: Model2Binding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(Donner1: Donner,Donner2: Donner) {
        binding.affichagebouton1 = Donner1
        binding.affichagebouton2 = Donner2
        Log.println(Log.INFO,"savoir si sa passe","savoir si sa passe")

    }

}