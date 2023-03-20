package com.example.shopika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private lateinit var btnAddItem : Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.greetingTextView)

        val name = intent.getStringExtra("name")
        greetingTextView.text = "Welcome, $name!"

        btnAddItem = findViewById(R.id.btn_Add_Item)

        btnAddItem.setOnClickListener{
            val intent = Intent(this, Todayshopping::class.java)
            startActivity(intent)
        }
    }
}