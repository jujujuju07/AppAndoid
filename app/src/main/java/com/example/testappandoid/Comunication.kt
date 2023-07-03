package com.example.testappandoid

import android.util.Log
import com.example.testappandoid.databinding.ActivityMainBinding
import com.example.testappandoid.model.Donner
import com.example.testappandoid.model.Structure
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.net.InetAddress
import java.net.Socket
import kotlin.system.exitProcess


class Comunication(private var mainActivity: MainActivity) {
    private lateinit var entre: BufferedReader
    private lateinit var sortie: PrintStream
    private lateinit var socket: Socket
    var marche = false
    private lateinit var binding: ActivityMainBinding
    lateinit var DonnerAll : Structure
    var donnerrecu = false

    fun binding(binding: ActivityMainBinding){
        this.binding = binding
    }

    fun conection(ip:String){
        GlobalScope.launch {

            var port = 1222
            var address = InetAddress.getByName(ip)
            try {
                socket = Socket(address,port)
                entre = BufferedReader(InputStreamReader(socket.getInputStream()))
                sortie = PrintStream(socket.getOutputStream())
                GlobalScope.launch(Dispatchers.Main) {
                    socket(socket,entre,sortie)
                }
                marche = true

            }catch (e:Exception){
                GlobalScope.launch(Dispatchers.Main) {
                    Log.i("connection","salut")
                }
            }
        }

    }


    fun requette(laRequette:String){
        message(laRequette)
        GlobalScope.launch {
            sortie.print(laRequette)
        }
    }

    fun run(){
        GlobalScope.launch {
            while (marche){
                try {
                    var requette = entre.readLine()
                    GlobalScope.launch(Dispatchers.Main) {
                        Log.i("reponse",requette)
                        if (requette != "exit"){
                            message(requette)
                        }else{
                            mainActivity.fin()
                        }
                    }
                }catch (e: Exception){
                    Log.e(e.cause.toString(), e.message.toString())
                    marche = false
                }
            }
        }
    }

    private fun message(message:String) {
        GlobalScope.launch(Dispatchers.Main){
            try {
                Log.println(Log.INFO,"JSON",message)
                var gson = Gson()
                var test = listOf<Donner>()
                DonnerAll = Structure(test,"")
                DonnerAll = gson.fromJson(message,DonnerAll.javaClass)
                donnerrecu = true
            }catch (e:Exception){
                Log.println(Log.INFO,"tag",e.message.toString())
            }

        }


    }

    private fun socket(socket:Socket,entre:BufferedReader,sortie:PrintStream) {
        this.socket = socket
        this.entre = entre
        this.sortie = sortie
        run()
    }

}

