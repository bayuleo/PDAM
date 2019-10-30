package com.example.pdammvp.view.history

import com.example.pdammvp.models.parser.HistoryParser
import com.example.pdammvp.models.pojo.History
import com.example.pdammvp.network.Client
import com.example.pdammvp.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryPresenter constructor(val view: HistoryContract.View): HistoryContract.Presenter{
    override fun getDataHistory() {
        try{
            val client = Client()
            val apiService = client.getClient().create(Service::class.java)
            val call: Call<HistoryParser> = apiService.getHistory()
            call.enqueue(object : Callback<HistoryParser>{
                override fun onResponse(call: Call<HistoryParser>, response: Response<HistoryParser>
                ) {
                    val data = response.body()?.getmResult() as List<History>
                    view.onSuccessGetDataHistory(data)
                }

                override fun onFailure(call: Call<HistoryParser>, t: Throwable) {
                    view.onFailedGetDataHistory(t.message)
                }

            })

        } catch (e: Exception){

        }
    }

}