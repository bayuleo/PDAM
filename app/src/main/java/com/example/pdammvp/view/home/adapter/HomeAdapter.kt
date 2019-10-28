package com.example.pdammvp.view.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdammvp.R
import com.example.pdammvp.models.pojo.Product

class HomeAdapter constructor(val mContext: Context, var list: MutableList<Product>):
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false)
        val holder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
//        return list.size
        return 20
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    fun updateData(list: MutableList<Product>?){
        list!!.clear()
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }

}