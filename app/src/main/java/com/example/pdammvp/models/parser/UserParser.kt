package com.example.pdammvp.models.parser

import com.example.pdammvp.models.pojo.User
import com.google.gson.annotations.SerializedName

class UserParser {

    @SerializedName("results")
    var mResult: List<User>? = null

    fun getmResult():List<User>?{
        return mResult
    }

    fun setmResult(mResult :List<User>){
        this.mResult = mResult
    }

}