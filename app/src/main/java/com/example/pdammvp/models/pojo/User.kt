package com.example.pdammvp.models.pojo

import com.google.gson.annotations.SerializedName

data class User(

    @field:SerializedName("email")
    var email: String = "",

    @field:SerializedName("username")
    var username: String = "",

    @field:SerializedName("password")
    var password: String = ""

)