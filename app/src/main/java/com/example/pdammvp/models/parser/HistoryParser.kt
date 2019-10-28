package com.example.pdammvp.models.parser

import com.example.pdammvp.models.pojo.History
import com.example.pdammvp.models.pojo.User
import com.google.gson.annotations.SerializedName

class HistoryParser {

    @SerializedName("results")
    var mResult: List<History>? = null

    fun getmResult():List<History>?{
        return mResult
    }

    fun setmResult(mResult :List<History>){
        this.mResult = mResult
    }

}