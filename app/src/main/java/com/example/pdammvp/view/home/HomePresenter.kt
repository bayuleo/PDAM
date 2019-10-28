package com.example.pdammvp.view.home

import com.example.pdammvp.models.parser.ProductParser
import com.example.pdammvp.network.Client
import com.example.pdammvp.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter constructor(val view: HomeContract.View) : HomeContract.Presenter {
    override fun getDataProduct() {
        try{
            val client = Client()
            val apiService = client.getClient().create(Service::class.java)
            val call: Call<ProductParser> = apiService.getProduct("xxxxxx")
            call.enqueue(object : Callback<ProductParser>{
                override fun onResponse(call: Call<ProductParser>, response: Response<ProductParser>
                ) {
                    view.onSuccessGetData()
                }

                override fun onFailure(call: Call<ProductParser>, t: Throwable) {
                    view.onFailedGetData()
                }

            })

        } catch (e: Exception){

        }
    }

}