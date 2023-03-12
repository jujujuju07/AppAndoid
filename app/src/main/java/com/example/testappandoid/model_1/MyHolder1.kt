package com.example.testappandoid.model_1

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.databinding.Model1Binding
import com.example.testappandoid.model.Donner


class MyHolder1 (private val binding: Model1Binding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(Donner: Donner) {
        binding.affichagebouton = Donner
        Log.println(Log.INFO,"myholder1","savoir si sa passe")

    }

}