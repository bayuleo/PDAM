package com.example.pdammvp.network

import com.example.pdammvp.models.parser.UserParser
import com.example.pdammvp.models.pojo.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface Service {

    @GET("")
    fun getUser(
            @Query("api_key") apiKey: String): Call<UserParser>
}