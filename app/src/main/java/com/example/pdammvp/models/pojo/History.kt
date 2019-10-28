package com.example.pdammvp.models.pojo

import com.google.gson.annotations.SerializedName

data class History(

    @field:SerializedName("no")
    var no: String = "",

    @field:SerializedName("Name")
    var name: String = ""

)