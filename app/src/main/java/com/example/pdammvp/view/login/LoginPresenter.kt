package com.example.pdammvp.view.login

import com.example.pdammvp.models.parser.UserParser
import com.example.pdammvp.network.Client
import com.example.pdammvp.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginPresenter constructor(val view:LoginContract.View) : LoginContract.Presenter{

    override fun postLogin() {
        try {
            val client = Client()
            val apiService = client.getClient().create(Service::class.java)
            val call: Call<UserParser> = apiService.getUser("")
            call.enqueue(object : Callback<UserParser>{

                override fun onResponse(call: Call<UserParser>, response: Response<UserParser>) {
                   view.onSuccessLogin()
                }

                override fun onFailure(call: Call<UserParser>, t: Throwable) {
                    view.onFailedLogin()
                }

            })

        } catch (e: Exception){

        }
    }

}