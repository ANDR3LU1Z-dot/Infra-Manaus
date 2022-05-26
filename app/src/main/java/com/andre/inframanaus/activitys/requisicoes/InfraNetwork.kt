package com.andre.inframanaus.activitys.requisicoes

import android.util.Log
import com.andre.inframanaus.body.BodyCardPostagens
import com.andre.inframanaus.body.ResponseListaDenuncias
import com.andre.inframanaus.response.ResponseCadastroDenuncia
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object InfraNetwork {

fun cadastrarDenuncia(api: ApiRetrofit, body: BodyCardPostagens, callbackRetorno: (response: ResponseCadastroDenuncia)-> Unit){
    val call = api.service.cadastrarDenuncia(body)

    call.enqueue(object: Callback<ResponseCadastroDenuncia>{
        override fun onResponse(
            call: Call<ResponseCadastroDenuncia>,
            response: Response<ResponseCadastroDenuncia>
        ) {
            Log.i("Sucesso", "Denuncia cadastrada")
            //Invocando o response da requisicao no callback
            response.body()?.let {
                (callbackRetorno.invoke(it)) }
        }

        override fun onFailure(call: Call<ResponseCadastroDenuncia>, t: Throwable) {
            java.lang.Exception()
            Log.i("ERRO", "Ocorreu algum erro")
        }

    })
}

    fun listarDenuncias(api: ApiRetrofit){
        val call = api.service.listaDenuncias()

        call.enqueue(object : Callback<ResponseListaDenuncias>{
            override fun onResponse(
                call: Call<ResponseListaDenuncias>,
                response: Response<ResponseListaDenuncias>
            ) {
                if(response.isSuccessful){
                    val body = response.body()

                    body?.postagens?.let {
                        Log.d("userPostagem","sucesso")
                    }
                }

                Log.d("Denuncias", "denuncias carregadas")
            }

            override fun onFailure(call: Call<ResponseListaDenuncias>, t: Throwable) {
                Log.d("Falha", "deu ruim")
            }

        })
    }
}