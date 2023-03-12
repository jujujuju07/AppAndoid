package com.example.testappandoid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.databinding.ActivityMainBinding
import com.example.testappandoid.model_1.MyAdapter1
import com.example.testappandoid.model_2.MyAdapter2
import com.example.testappandoid.model_3.MyAdapter3
import com.example.testappandoid.test.MyAdapter
//import com.example.testappandoid.model_3.MyAdapter3
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var comunication: Comunication
    private lateinit var recyclerViewNews : RecyclerView
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
        GlobalScope.launch(Dispatchers.Main){
            try{
                withContext(Dispatchers.IO) {
                    Thread.sleep(1000)
                }
                Thread.sleep(1000)
                Log.println(Log.INFO,"line","test")
                Log.println(Log.INFO,"lineline",comunication.DonnerAll.line)
                Log.println(Log.INFO,"line","test")



                recyclerViewNews = binding.rv
                val newAdapter = MyAdapter(comunication.DonnerAll)
                recyclerViewNews.adapter = newAdapter
                val layoutManager = LinearLayoutManager(parent,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewNews.layoutManager = layoutManager


                /*if (comunication.DonnerAll.line == "1"){
                    recyclerViewNews = binding.rv
                    val newsAdapter = MyAdapter1(comunication.DonnerAll)
                    recyclerViewNews.adapter = newsAdapter
                    val layoutManager = LinearLayoutManager(parent, LinearLayoutManager.HORIZONTAL, false)
                    recyclerViewNews.layoutManager = layoutManager
                }else if (comunication.DonnerAll.line == "2"){
                    recyclerViewNews = binding.rv
                    val newsAdapter = MyAdapter2(comunication.DonnerAll)
                    recyclerViewNews.adapter = newsAdapter
                    val layoutManager = LinearLayoutManager(parent,LinearLayoutManager.HORIZONTAL,false)
                    recyclerViewNews.layoutManager = layoutManager
                }else if (comunication.DonnerAll.line == "3"){
                    recyclerViewNews = binding.rv
                    val newsAdapter = MyAdapter3(comunication.DonnerAll,comunication)
                    recyclerViewNews.adapter = newsAdapter
                    val layoutManager = LinearLayoutManager(parent,LinearLayoutManager.HORIZONTAL,false)
                    recyclerViewNews.layoutManager = layoutManager
                    Log.println(Log.INFO,"line","3")
                }else{

                }*/


            }catch (e:Exception){
                Log.println(Log.ERROR,"tag",e.message.toString())
            }
        }

    }

}
