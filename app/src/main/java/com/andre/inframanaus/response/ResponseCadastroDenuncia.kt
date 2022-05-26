package com.andre.inframanaus.response

data class ResponseCadastroDenuncia(
    val comment: String,
    val tipoDenuncia: String,
    val tipoRisco: String,
    val username: String,
    val risco: String,
    val urlImage: String,
    val createdAt: String,
    val updateAt: String,
    val id: Int
)
