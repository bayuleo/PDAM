package com.example.pdammvp.view.login

class LoginContract {

    interface View {
        fun onSuccessLogin()
        fun onFailedLogin()
    }

    interface Presenter {
        fun postLogin()
    }

}