package com.andre.inframanaus.body

data class ResponseListaDenuncias(
    val status: Boolean,
    val postagens: List<ListaDenuncias>
)

data class ListaDenuncias (
    val id: Int,
    val comment: String,
    val urlImage: String,
    val userName: String,
    val tipoDenuncia: String,
    val tipoRisco: String,
    val risco: String,
    val createAt: String,
    val updateAt: String

    )