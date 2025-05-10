package com.jsalas.myapplication.TemasKotlin

//Piramide
// 2)realizar una piramide de asteriscos, realizar la piramide de los numeros de asteriscos que se pide
//al colocar 0 el programa va a finalizar, pero solo utilizando el do/while
//resultado deseado
//*
//**
//***
fun main() {
    do {
        print("Ingrese un numero: ")
        val num = readln().toInt()

        var f = 1
        do {
            var a = 1
            do {
                if(num!=0) {
                    print("*")
                }
                a++
            } while (a <= f)

            println()
            f++
        } while (f <= num)
    } while (num!= 0)
}