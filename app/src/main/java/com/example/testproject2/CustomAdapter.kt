package com.example.homework2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject2.DataVo
import com.example.testproject2.R

class CustomAdapter(private val context: Context, private val dataList: ArrayList<DataVo>) :
    RecyclerView.Adapter<CustomAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val useraccount : TextView = itemView.findViewById(R.id.item_txt1)
        private val useraccountlist : TextView= itemView.findViewById(R.id.item_txt2)
        private val userdate : TextView = itemView.findViewById(R.id.item_txt3)

        fun bind(dataVo: DataVo, context: Context){
            useraccount.text = dataVo.account
            useraccountlist.text = dataVo.account_list
            userdate.text = dataVo.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}