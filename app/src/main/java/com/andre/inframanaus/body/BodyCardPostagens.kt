package com.andre.inframanaus.body

import android.widget.ImageView

val cardPostagensList = mutableListOf<MockupDenuncias>()

data class BodyCardPostagens(

    var risco: String?,
    var username: String?,
    var tipo_denuncia: String?,
    var tipoRisco: String?,
    var imgDenuncia: String?,
    var comentario: String?,
    var base64: String?

)
