package com.example.pdammvp.models.pojo

import com.google.gson.annotations.SerializedName

data class History(

    @field:SerializedName("no")
    var no: Int = 0,

    @field:SerializedName("name")
    var name: String = ""

)