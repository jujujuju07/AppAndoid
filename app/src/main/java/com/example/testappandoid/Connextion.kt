package com.example.testappandoid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket

class Connextion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connextion)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(it.context, MainActivity::class.java)
            val text = findViewById<EditText>(R.id.editTextTextPersonName)
            intent.putExtra("ip",text.text.toString())
            it.context.startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        conection()
    }

    private fun conection(){
        GlobalScope.launch(Dispatchers.IO){
            var message: String
            val multicastSocket = MulticastSocket(4446)

            val multicastGroup = InetAddress.getByName("224.0.0.107")
            multicastSocket.joinGroup(multicastGroup)

            val buffer = ByteArray(1024)
            val packet = DatagramPacket(buffer, buffer.size)
            Log.i("salut","salut")
            multicastSocket.receive(packet)
            message = String(packet.data, 0, packet.length)
            Log.i("ip",message + " " + packet.length + " " + message.length)
            multicastSocket.leaveGroup(multicastGroup)
            GlobalScope.launch(Dispatchers.Main){
                val intent = Intent(this@Connextion, MainActivity::class.java)
                intent.putExtra("ip",message)
                startActivity(intent)
            }

        }

    }
}