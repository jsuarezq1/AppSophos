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
data class Documents(
    val Count: Int,
    val Items: List<Document>,
    val ScannedCount: Int
)
data class Document(
    val IdRegistro: String,
    val Fecha: String,
    val TipoId: String,
    val Identificacion: String,
    val Nombre: String,
    val Apellido: String,
    val Ciudad: String,
    val Correo: String,
    val TipoAdjunto: String,
    val Adjunto: String
)
data class NewDocument(
    val TipoId: String,
    val Identificacion: String,
    val Nombre: String,
    val Apellido: String,
    val Ciudad: String,
    val Correo: String,
    val TipoAdjunto: String,
    val Adjunto: String,
    val put: Boolean?
)