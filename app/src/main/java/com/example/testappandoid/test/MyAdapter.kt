package com.example.testappandoid.test

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.databinding.Model1Binding
import com.example.testappandoid.databinding.ModelBinding
import com.example.testappandoid.model.Donner
import com.example.testappandoid.model.Structure

class MyAdapter (private val donnerALL: Structure) : RecyclerView.Adapter<MyHolder>() {
    private lateinit var binding : ModelBinding
    var debut = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        binding = ModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        Log.println(Log.INFO,"myadapter","savoir si sa passe")

        return MyHolder(binding)
    }

    override fun getItemCount(): Int = donnerALL.Donner.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var listDonner = mutableListOf<Donner>()
        var longeur = (donnerALL.Donner.size / donnerALL.line.toInt())
        while (debut<donnerALL.Donner.size){
            listDonner.add(donnerALL.Donner.get(debut))
            //Log.println(Log.INFO,"adapterbind","salut")
            debut++

        }
        var donneSlect = Structure(listDonner,donnerALL.line)
        Log.println(Log.INFO,"adapterbind",donnerALL.Donner.size.toString())
        Log.println(Log.INFO,"adapterbind",debut.toString())
        Log.println(Log.INFO,"adapterbind",longeur.toString())
        Log.println(Log.INFO,"adapterbind",position.toString())


        holder.bind(donneSlect)
    }


}