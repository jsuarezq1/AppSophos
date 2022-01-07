package com.sophos.myappr

data class City(
    val Count: Int,
    val Items: List<Item>,
    val ScannedCount: Int
)

data class Item(
    val Ciudad: String,
    val IdOficina: Int,
    val Latitud: String,
    val Longitud: String,
    val Nombre: String
)
data class Usuario(
    val idUsuario: String,
    val acceso: Boolean,
    val admin: Boolean,
    val apellido: String,
    val id: String,
    val nombre: String,
    val clave: String
)