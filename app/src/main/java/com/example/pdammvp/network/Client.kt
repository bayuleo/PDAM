package com.example.pdammvp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    val BASE_URL= "http://www.mocky.io/v2/"

    fun getClient(): Retrofit {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}