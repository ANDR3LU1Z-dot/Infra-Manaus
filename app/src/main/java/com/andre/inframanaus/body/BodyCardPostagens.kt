package com.andre.inframanaus.body

val cardPostagensList = mutableListOf<BodyCardPostagens>()
data class BodyCardPostagens(

    var risco: String,
    var nome: String,
    var tipoRisco: String,
    val id: Int? = cardPostagensList.size

)
