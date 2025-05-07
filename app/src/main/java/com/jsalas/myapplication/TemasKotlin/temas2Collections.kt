package com.jsalas.myapplication.TemasKotlin

/*
lista
Map
MutableMap
MutableSet
SetOf
MutableSetOf


val readOnlyFiguras= listOf("cuadrado","triangulo","circulo")
println(readOnlyFiguras)
var mutableFiguras = mutableListOf("cuadrado","triangulo","circulo")
val readOnlyFiguras= listOf("cuadrado","triangulo","circulo")
val mutableFiguras:List<String> = figura

val fruntas = setOf("manzana","banana","naranja")
val frutas= mutableSetOf("manzana","banana","naranja")

val coches= mapOf("uno" to 1,"dos" to 2, "tres" to 3)
println(coches)
val coches2= mutableMapOf("uno" to 1,"dos" to 2, "tres" to 3)
println(coches2)


* */

fun main(){
    val readOnlyFiguras = listOf("cuadrado", "triangulo", "circulo")
    println(readOnlyFiguras)
    println("La primera figura es ${readOnlyFiguras[0]}")
    println("El primer elemento de la lista es ${readOnlyFiguras.first()}")
    println("Numero de elementos en la lista ${readOnlyFiguras.count()} items")
    println("circulo" in readOnlyFiguras)
    println(readOnlyFiguras)
    //readOnlyFiguras.add("pentagono")
    var figura: MutableList<String> = mutableListOf("cuadrado2", "triangulo2", "circulo2")
    println(figura)
    figura.add("pentagono2")
    println(figura)
    figura.remove("cuadrado2")
    println(figura)
}

