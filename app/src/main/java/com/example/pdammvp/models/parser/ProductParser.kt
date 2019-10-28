package com.example.pdammvp.models.parser

import com.example.pdammvp.models.pojo.Product
import com.google.gson.annotations.SerializedName

class ProductParser {

    @SerializedName("results")
    var mResult: List<Product>? = null

    fun getmResult():List<Product>?{
        return mResult
    }

    fun setmResult(mResult: List<Product>){
        this.mResult = mResult
    }

}