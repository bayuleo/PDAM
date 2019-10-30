package com.example.pdammvp.view.home

import com.example.pdammvp.models.pojo.Product

class HomeContract {

    interface View {
        fun onSuccessGetData(list: List<Product>)
        fun onFailedGetData(message: String?)
    }

    interface Presenter {
        fun getDataProduct()
    }

}