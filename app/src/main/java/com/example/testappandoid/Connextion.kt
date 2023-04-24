package com.example.testappandoid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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


}