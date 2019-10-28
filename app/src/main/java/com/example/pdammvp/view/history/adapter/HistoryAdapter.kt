package com.example.pdammvp.view.history.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdammvp.R
import com.example.pdammvp.models.pojo.History

class HistoryAdapter constructor(val mContext: Context, var list: MutableList<History>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(mContext).inflate(R.layout.item_history, parent, false)
        val holder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: HistoryAdapter.ViewHolder, position: Int) {

    }

    fun updateData(list: MutableList<History>){
        this.list!!.clear()
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }

}
