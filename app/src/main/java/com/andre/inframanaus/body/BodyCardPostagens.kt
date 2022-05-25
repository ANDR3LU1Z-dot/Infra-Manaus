package com.andre.inframanaus.body

import android.widget.ImageView

val cardPostagensList = mutableListOf<BodyCardPostagens>()

data class BodyCardPostagens(

    var risco: String,
    var nome_usuario: String,
    var tipo_denuncia: String,
    var imgDenuncia: Int,
    var tipoRisco: String,
    val id: Int? = cardPostagensList.size

)
