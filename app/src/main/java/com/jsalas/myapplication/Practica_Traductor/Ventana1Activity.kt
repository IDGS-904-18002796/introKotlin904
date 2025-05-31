package com.jsalas.myapplication.Practica_Traductor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jsalas.myapplication.R
import com.jsalas.myapplication.tema1app.Ejemplo1Activity

class Ventana1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana1)
        val btnV2=findViewById<Button>(R.id.btnV2)
        btnV2.setOnClickListener{navegateToVentana2()}
        val btnV3=findViewById<Button>(R.id.btnV3)
        btnV3.setOnClickListener{navegateToVentana3()}
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navegateToVentana2(){
        val intent= Intent(this, Ventana2Activity::class.java)
        startActivity(intent)
    }
    private fun navegateToVentana3(){
        val intent= Intent(this, Ventana3Activity::class.java)
        startActivity(intent)
    }
}