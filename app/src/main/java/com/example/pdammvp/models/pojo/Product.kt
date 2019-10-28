package com.example.pdammvp.models.pojo

import com.google.gson.annotations.SerializedName

data class Product(

    @field:SerializedName("name")
    var name: String = "",

    @field:SerializedName("price")
    var price: String = ""
)