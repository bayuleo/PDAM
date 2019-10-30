package com.example.pdammvp.view.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pdammvp.R
import com.example.pdammvp.models.pojo.Product
import org.w3c.dom.Text

class HomeAdapter constructor(val mContext: Context?, var list: MutableList<Product>):
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false)
        val holder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list.get(position)
        holder.title.text = data.name
        holder.price.text = data.price

    }

    fun updateData(list: MutableList<Product>){
        this.list!!.clear()
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView     = itemView.findViewById(R.id.tv_product_title)
        var image: ImageView    = itemView.findViewById(R.id.img_product)
        var price: TextView     = itemView.findViewById(R.id.tv_product_price)
    }

}