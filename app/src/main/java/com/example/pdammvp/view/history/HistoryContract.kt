package com.example.pdammvp.view.history

import com.example.pdammvp.models.pojo.History

class HistoryContract {

    interface View {
        fun onSuccessGetDataHistory(list: List<History>)
        fun onFailedGetDataHistory(message: String?)
    }


    interface Presenter {
        fun getDataHistory()
    }
}