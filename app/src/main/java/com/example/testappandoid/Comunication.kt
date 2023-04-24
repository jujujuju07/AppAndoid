package com.example.testappandoid

import android.content.Intent
import android.util.Log
import com.example.testappandoid.databinding.ActivityMainBinding
import com.example.testappandoid.model.Donner
import com.example.testappandoid.model.Structure
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintStream
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket
import java.net.Socket
import javax.security.auth.login.LoginException


class Comunication(private var mainActivity: MainActivity) {
    private lateinit var entre: BufferedReader
    private lateinit var sortie: PrintStream
    private lateinit var socket: Socket
    var marche = false
    private lateinit var binding: ActivityMainBinding
    lateinit var DonnerAll : Structure

    fun binding(binding: ActivityMainBinding){
        this.binding = binding
    }

    fun conection(){
        GlobalScope.launch {
            var message = "";
            var connexion_multicast = false;
            val multicastSocket = MulticastSocket(4446)

            val multicastGroup = InetAddress.getByName("224.0.0.1")
            multicastSocket.joinGroup(multicastGroup)

            val buffer = ByteArray(1024)
            val packet = DatagramPacket(buffer, buffer.size)
            GlobalScope.launch {
                Thread.sleep(5000)
                if (!connexion_multicast){


                    connection("10.0.0.109")
                }
            }

            multicastSocket.receive(packet)
            message = String(packet.data, 0, packet.length)
            Log.i("ip",message + " " + packet.length + " " + message.length)
            //println("Message reçu : $message")
            connexion_multicast = true
            connection(message)

        }

    }

    fun connection(ip:String){
        GlobalScope.launch {

            var port = 1222
            var address = InetAddress.getByName("10.0.0.109")
            try {
                socket = Socket(address,port)
                entre = BufferedReader(InputStreamReader(socket.getInputStream()))
                sortie = PrintStream(socket.getOutputStream())
                GlobalScope.launch(Dispatchers.Main) {
                    socket(socket,entre,sortie)
                }
                marche = true
                //conect = true

            }catch (e:Exception){
                GlobalScope.launch(Dispatchers.Main) {
                    Log.i("connection","salut")
                    //message(e.toString())
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
                var requette = entre.readLine()
                GlobalScope.launch(Dispatchers.Main) {
                    message(requette)

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

