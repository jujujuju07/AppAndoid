package com.example.testappandoid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testappandoid.databinding.ActivityMainBinding
import com.example.testappandoid.model.Donner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var comunication: Comunication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        comunication = Comunication(this)
        comunication.conection()
        Log.println(Log.INFO,"savoir si sa passe","savoir si sa passe MainActivity")
        construire()


    }

    private fun construire(){
        var list: MutableList<Donner>
        val test = this
        Log.println(Log.INFO,"Donner","passe")

        GlobalScope.launch(Dispatchers.Main){
            withContext(Dispatchers.IO) {
                Thread.sleep(1000)
            }
            Thread.sleep(1000)
            Log.println(Log.INFO,"Donner","passe")

            Log.println(Log.INFO,"line","test")
            Log.println(Log.INFO,"lineline",comunication.DonnerAll.line)
            Log.println(Log.INFO,"line","test")

            list = comunication.DonnerAll.Donner.toMutableList()

            val gridview = binding.gridview
            gridview.numColumns = comunication.DonnerAll.Donner.size / comunication.DonnerAll.line.toInt()
            Log.println(Log.INFO,"Donner","passe")
            gridview.setAdapter(ImageAdapter(test,list,comunication))
            Log.println(Log.INFO,"Donner","passe")
        }
            /*var marche = false
            var i = 0
            while (!marche){
                var donner = Donner("http://192.168.1.17:8080/image/Games/Among-Us.png","test")
                list.add(donner)
                if (i>20){
                    marche=true
                }
                //Log.println(Log.INFO,"Donner",comunication.DonnerAll.Donner[i].image + " " + comunication.DonnerAll.Donner[i].text)
                Log.println(Log.INFO,"Donner",donner.image + " " + donner.text)
                i++
            }
        val gridview = binding.gridview
        gridview.numColumns = 10
        Log.println(Log.INFO,"Donner","passe")
        gridview.setAdapter(ImageAdapter(this,list))
        Log.println(Log.INFO,"Donner","passe")*/

    }

}
