package com.andre.inframanaus

import com.andre.inframanaus.body.BodyCardPostagens
import com.andre.inframanaus.body.ResponseListaDenuncias
import com.andre.inframanaus.response.ResponseCadastroDenuncia
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {


    @POST("/cadastro")
    fun cadastrarDenuncia(
        @Body body: BodyCardPostagens
    ): Call<ResponseCadastroDenuncia>


    @GET("posts")
    fun listaDenuncias():Call<ResponseListaDenuncias>
}