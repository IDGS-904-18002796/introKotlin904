package com.jsalas.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jsalas.myapplication.Practica_Cinepolis.cinepolisAndroidActivity
import com.jsalas.myapplication.Tem2App.Ejemplo2Activity
import com.jsalas.myapplication.tema1app.Ejemplo1Activity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnEjemplo1=findViewById<Button>(R.id.btn1)
        btnEjemplo1.setOnClickListener{navegateToEjemplo1()}
        val btnEjemploCinepolis = findViewById<Button>(R.id.btn2)
        btnEjemploCinepolis.setOnClickListener { navigateToCinepolis() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnEjemplo2 = findViewById<Button>(R.id.btn3)
        btnEjemplo2.setOnClickListener { navigateToEjemplo2() }

    }
    private fun navegateToEjemplo1(){
val intent=Intent(this,Ejemplo1Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToCinepolis(){
        val intent = Intent(this, cinepolisAndroidActivity::class.java)
        startActivity(intent)

    }
    private fun navigateToEjemplo2(){
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)

    }
}