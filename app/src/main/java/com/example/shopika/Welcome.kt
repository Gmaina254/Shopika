package com.example.shopika

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

private lateinit var editText : TextInputEditText
@SuppressLint("StaticFieldLeak")
private lateinit var btnNext : Button

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        editText = findViewById(R.id.edtName)
        btnNext = findViewById(R.id.btn_Next)

        btnNext.setOnClickListener{
            if (editText.text == null || editText.text.toString().trim().isEmpty()){
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show();
            }else {
                val name = editText.text.toString()
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("name", name)
                }
                startActivity(intent)
            }
        }
    }
}
