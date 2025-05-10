package com.jsalas.myapplication.TemasKotlin

//Formula General
// 3)Permita calcular la formula general
// pedir 3 numeros y da como resultado 2 numeros y validar que no haya raices negativas o 0,"no puedo realizarla" hasta que no de error

fun main(){
    var f = 0
    do{
        println("Ingrese a:")
        val a= readln().toDouble()
        println("Ingrese b:")
        val b= readln().toDouble()
        println("Ingrese c:")
        val c= readln().toDouble()
        val raiz = b * b - 4 * a * c

        if(raiz<0 || a == 0.0){
            println("no se puede realizar raices con numeros negativos o dividir entre 0")
            println("vuelve a intentar")
        }else {
            val x1 = (-b + Math.sqrt(raiz)) / (2 * a)
            val x2 = (-b - Math.sqrt(raiz)) / (2 * a)
            println("x1 = $x1")
            println("x2 = $x2")
            f = 1
        }

    }while(f==0)
}