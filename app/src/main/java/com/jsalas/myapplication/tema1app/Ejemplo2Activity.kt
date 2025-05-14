package com.jsalas.myapplication.tema1app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jsalas.myapplication.R

class Ejemplo2Activity : AppCompatActivity() {
    private lateinit var et_a: EditText
    private lateinit var et_b: EditText
    private lateinit var tv1: TextView
    private lateinit var btn1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)
        et_a = findViewById<EditText>(R.id.et1)
        et_b = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        btn1 = findViewById<Button>(R.id.btn1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: android.view.View) {
        val a = et_a.text.toString().toDouble()
        val b = et_b.text.toString().toInt()
        var resultado = 0.0
        for (i in 1..b) {
            resultado += a
        }
        tv1.text = resultado.toString()
    }
}