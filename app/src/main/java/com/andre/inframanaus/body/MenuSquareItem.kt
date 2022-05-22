package com.andre.inframanaus.body

import androidx.annotation.DrawableRes

/**
 * Classe criada para criar os icones do Menu
 * @param label String
 * @param drawable Int
 */
data class MenuSquareItem(


    val label: String,
    @DrawableRes
    val drawable: Int

)
