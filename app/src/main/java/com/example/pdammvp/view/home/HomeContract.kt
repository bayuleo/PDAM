package com.example.pdammvp.view.home

class HomeContract {

    interface View {
        fun onSuccessGetData()
        fun onFailedGetData()
    }

    interface Presenter {
        fun getDataProduct()
    }

}