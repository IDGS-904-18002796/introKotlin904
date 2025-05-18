package com.jsalas.myapplication.Practica_Cinepolis

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jsalas.myapplication.R

class cinepolisAndroidActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etCompradores: EditText
    private lateinit var etBoletos: EditText
    private lateinit var rgTarjeta: RadioGroup
    private lateinit var rbSi: RadioButton
    private lateinit var rbNo: RadioButton
    private lateinit var tvTotal: TextView
    private lateinit var btnCalcular: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis_android)
        etNombre = findViewById(R.id.etNombre)
        etCompradores = findViewById(R.id.etCompradores)
        etBoletos = findViewById(R.id.etBoletos)
        rgTarjeta = findViewById(R.id.rgTarjeta)
        rbSi = findViewById(R.id.rbSi)
        rbNo = findViewById(R.id.rbNo)
        tvTotal = findViewById(R.id.tvTotal)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            when {
                etNombre.text.isEmpty() -> AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Ingrese el nombre")
                    .setPositiveButton("Aceptar", null)
                    .show()

                etCompradores.text.isEmpty() -> AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Ingrese cantidad de compradores")
                    .setPositiveButton("Aceptar", null)
                    .show()

                etBoletos.text.isEmpty() -> AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Ingrese cantidad de boletos")
                    .setPositiveButton("Aceptar", null)
                    .show()

                rgTarjeta.checkedRadioButtonId == -1 -> AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Seleccione si tiene tarjeta o no")
                    .setPositiveButton("Aceptar", null)
                    .show()

                else -> calcular()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular() {
        val nombre = etNombre.text.toString()
        val compradores = etCompradores.text.toString().toInt()
        val boletos = etBoletos.text.toString().toInt()
        val tieneTarjeta = rgTarjeta.checkedRadioButtonId == R.id.rbSi

        if (boletos > compradores * 7) {
            AlertDialog.Builder(this)
                .setTitle("Limite excedido")
                .setMessage("Solo puedes comprar 7 boletos por persona")
                .setPositiveButton("Aceptar", null)
                .show()
            return
        }

        val precioBoleto = 12000.0
        var total = boletos * precioBoleto
        var descuentos = ""

        when {
            boletos > 5 -> {
                val descuento = total * 0.15
                total -= descuento
                descuentos += "-Descuento de 15% aplicado \n        -"
            }
            boletos >= 3 -> {
                val descuento = total * 0.10
                total -= descuento
                descuentos += "-Descuento de 10% aplicado \n        -"
            }
            else -> {
                descuentos += "-No aplica descuento por cantidad \n        -"
            }
        }

        if (tieneTarjeta) {
            val descuentoTarjeta = total * 0.10
            total -= descuentoTarjeta
            descuentos += "Descuento Tarjeta Cineco (10%) \n"
        } else {
            descuentos += "Sin descuento por Tarjeta Cineco \n"
        }

        val mensaje = """
        Nombre: $nombre
        Cantidad de compradores: $compradores
        Boletos comprados: $boletos
        
        Precio sin descuentos: $${"%.0f".format(boletos * precioBoleto)}
        
        Descuentos aplicados:
        $descuentos
        
        TOTAL(Descuentos aplicados): $${"%.0f".format(total)}
    """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Resumen de Compra")
            .setMessage(mensaje)
            .setPositiveButton("Aceptar", null)
            .show()

        tvTotal.text = "$${"%.0f".format(total)}"
    }

}