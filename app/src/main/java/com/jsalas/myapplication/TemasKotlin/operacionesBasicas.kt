package com.jsalas.myapplication.TemasKotlin

//OperacionesBasicas
//1)ejercicio que me realice las operaciones basicas
//        que operacion quieres hacer y salir


fun main() {
    do {
        println("Seleccione una opcion")
        println("1. Sumar")
        println("2. Restar")
        println("3. Multiplicar")
        println("4. Dividir")
        println("5. Salir")
        print("Elige una opcion: ")

       val opcion = readln().toInt()

        if (opcion in 1..4) {
            print("Ingresa el primer numero: ")
            val num1 = readln().toDouble()
            print("Ingresa el segundo numero: ")
            val num2 = readln().toDouble()

            when (opcion) {
                1 -> println("Resultado: ${num1 + num2}")
                2 -> println("Resultado: ${num1 - num2}")
                3 -> println("Resultado: ${num1 * num2}")
                4 -> { if (num2 != 0.0) {
                        println("Resultado: ${num1 / num2}")
                    } else {
                        println("No se puede dividir entre cero")
                    }
                }
            }
        }
    } while (opcion != 5)
}