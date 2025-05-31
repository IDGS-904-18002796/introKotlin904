package com.jsalas.myapplication.Practica_Traductor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jsalas.myapplication.R

class Ventana2Activity : AppCompatActivity() {
    private val fileName = "diccionario.txt"
    private lateinit var etIngles: EditText
    private lateinit var etEspanol: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana2)
        etIngles = findViewById(R.id.etIng)
        etEspanol = findViewById(R.id.etEsp)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnV1 = findViewById<Button>(R.id.btnV1)

        btnGuardar.setOnClickListener {
            guardarPalabras(etIngles.text.toString(), etEspanol.text.toString())
        }
        btnV1.setOnClickListener{navegateToVentana1()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToVentana1(){
        val intent= Intent(this, Ventana1Activity::class.java)
        startActivity(intent)
    }
    private fun guardarPalabras(palabraIngles: String, palabraEspanol: String) {
        if(palabraIngles.isNotEmpty() && palabraEspanol.isNotEmpty()) {
            try {
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write("$palabraIngles:$palabraEspanol\n".toByteArray())
                }
                findViewById<EditText>(R.id.etIng).text.clear()
                findViewById<EditText>(R.id.etEsp).text.clear()
                Toast.makeText(this,"Palabra guardada con exito",Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this,"Error al guardar palabra",Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this,"Ingrese ambas palabras",Toast.LENGTH_LONG).show()
        }
    }
}