package com.example.pdammvp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    val BaseURL= ""

    fun getClient(): Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}