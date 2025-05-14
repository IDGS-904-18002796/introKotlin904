package com.jsalas.myapplication.tema1app

import android.opengl.ETC1Util
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jsalas.myapplication.R

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var btn1: Button
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)
        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        btn1 = findViewById<Button>(R.id.btn1)
        radioGroup = findViewById(R.id.rg1)



        btn1.setOnClickListener {
            when (radioGroup.checkedRadioButtonId) {
                R.id.rb3 -> sumar(it)
                R.id.rb4 -> resta(it)
                R.id.rb1 -> multi(it)
                R.id.rb2 -> division(it)
                else -> tv1.text = "Seleccione una Opcion"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }


    fun sumar(view: android.view.View){
        val valor1= et1.text.toString()
        val valor2=et2.text.toString()
        val resultado =valor1.toDouble()+valor2.toDouble()
        tv1.text=resultado.toString()
    }

    fun resta(view: android.view.View){
        val valor1= et1.text.toString()
        val valor2=et2.text.toString()
        val resultado =valor1.toDouble()-valor2.toDouble()
        tv1.text=resultado.toString()
    }
    fun multi(view: android.view.View){
        val valor1= et1.text.toString()
        val valor2=et2.text.toString()
        val resultado =valor1.toDouble()*valor2.toDouble()
        tv1.text=resultado.toString()
    }
    fun division(view: android.view.View){
        val valor1= et1.text.toString()
        val valor2=et2.text.toString()
        val resultado =valor1.toDouble()/valor2.toDouble()
        tv1.text=resultado.toString()
    }

}