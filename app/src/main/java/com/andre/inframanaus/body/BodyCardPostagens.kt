package com.andre.inframanaus.body

import android.widget.ImageView

val cardPostagensList = mutableListOf<BodyCardPostagens>()

data class BodyCardPostagens(

    var risco: String?,
    var username: String?,
    var tipo_denuncia: String?,
    var tipoRisco: String?,
    val id: String?,
    val comentario: String?,
    var imgDenuncia: String?,

)
