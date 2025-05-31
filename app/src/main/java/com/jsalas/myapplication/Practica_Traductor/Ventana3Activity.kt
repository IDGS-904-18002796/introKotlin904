package com.jsalas.myapplication.Practica_Traductor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jsalas.myapplication.R

class Ventana3Activity : AppCompatActivity() {
    private val fileName = "diccionario.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana3)


        val etBuscar = findViewById<EditText>(R.id.et4)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val rbIng = findViewById<RadioButton>(R.id.rbIng)
        val btnV1=findViewById<Button>(R.id.btnV1)
        btnV1.setOnClickListener{navegateToVentana1()}


        btnBuscar.setOnClickListener{
            val palabra = etBuscar.text.toString()
            if(palabra.isNotEmpty()) {
                try {
                    val contenido = openFileInput(fileName).bufferedReader().useLines { lines ->
                        lines.joinToString("\n")
                    }
                    val resultado = buscarPalabra(contenido, palabra, rbIng.isChecked)
                    if(resultado.isNotEmpty()) {
                        Toast.makeText(this,"Traduccion: $resultado",Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this,"Palabra no encontrada",Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this,"Error al buscar",Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this,"Ingrese una palabra",Toast.LENGTH_LONG).show()
            }
        }

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
    private fun buscarPalabra(contenido: String, palabra: String, esIngles: Boolean): String {
        contenido.split("\n").forEach { linea ->
            val partes = linea.split(":")
            if(partes.size == 2) {
                if(esIngles && partes[0].equals(palabra, true)) {
                    return partes[1]
                } else if(!esIngles && partes[1].equals(palabra, true)) {
                    return partes[0]
                }
            }
        }
        return ""
    }
}