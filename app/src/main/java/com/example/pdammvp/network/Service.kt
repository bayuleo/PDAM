package com.example.pdammvp.network

import com.example.pdammvp.models.parser.HistoryParser
import com.example.pdammvp.models.parser.ProductParser
import com.example.pdammvp.models.parser.UserParser
import com.example.pdammvp.models.pojo.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface Service {

    @GET("")
    fun getUser(
        @Query("api_key") apiKey: String): Call<UserParser>

    @GET("5db9095130000064005ee04f")
    fun getProduct(): Call<ProductParser>

    @GET("5db91e6b30000075005ee096")
    fun getHistory(): Call<HistoryParser>
}