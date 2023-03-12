package com.example.testappandoid.model_3

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.Comunication
import com.example.testappandoid.databinding.Model3Binding
import com.example.testappandoid.model.Donner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MyHolder3 (private val binding: Model3Binding,var comunication: Comunication) : RecyclerView.ViewHolder(binding.root) {

    fun bind(Donner1: Donner,Donner2: Donner,Donner3: Donner) {
        binding.affichagebouton1 = Donner1
        binding.affichagebouton2 = Donner2
        binding.affichagebouton3 = Donner3
        Log.println(Log.INFO,"savoir si sa passe","savoir si sa passe")

        binding.imageButton1.setOnClickListener {
            button1()
        }
        binding.textView1.setOnClickListener {
            button1()
        }

        binding.imageButton2.setOnClickListener {
            button2()
        }
        binding.textView2.setOnClickListener {
            button2()
        }

        binding.imageButton3.setOnClickListener {
            button3()
        }
        binding.textView3.setOnClickListener {
            button3()
        }


    }

    fun button1(){
        var donner = Donner(binding.affichagebouton1!!.image,binding.affichagebouton1!!.text)
        comunication.requette(comunication.DonnerAll.Donner.indexOf(donner).toString())
    }

    fun button2(){
        GlobalScope.launch(Dispatchers.Main){
            var donner = Donner(binding.affichagebouton2!!.image,binding.affichagebouton2!!.text)
            comunication.requette(comunication.DonnerAll.Donner.indexOf(donner).toString())
        }
    }

    fun button3(){
        var donner = Donner(binding.affichagebouton3!!.image,binding.affichagebouton3!!.text)
        comunication.requette(comunication.DonnerAll.Donner.indexOf(donner).toString())
    }

}