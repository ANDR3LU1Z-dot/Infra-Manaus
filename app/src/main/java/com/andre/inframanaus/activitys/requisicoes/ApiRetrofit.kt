package com.andre.inframanaus.activitys.requisicoes

import android.content.Context
import com.andre.inframanaus.ApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiRetrofit(context: Context) {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://179.127.24.212:9666")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: ApiServices = retrofit.create(ApiServices::class.java)



}