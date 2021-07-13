package com.example.homework2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject2.DataVo
import com.example.testproject2.R

class CustomAdapter(private val context: Context, private val dataList: ArrayList<DataVo>) :
    RecyclerView.Adapter<CustomAdapter.ItemViewHolder>(){
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userphoto : ImageView = itemView.findViewById(R.id.item_img1)
        private val useraccount : TextView = itemView.findViewById(R.id.item_txt1)
        private val useraccountlist : TextView= itemView.findViewById(R.id.item_txt2)
        private val userdate : TextView = itemView.findViewById(R.id.item_txt3)

        fun bind(dataVo: DataVo, context: Context){
            val resourceId = context.resources.getIdentifier(dataVo.photo, "drawable", context.packageName)
            userphoto.setImageResource(resourceId)
            useraccount.text = dataVo.account
            useraccountlist.text = dataVo.account_list
            userdate.text = dataVo.date
        }
    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)
        return ItemViewHolder(view)
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return dataList.size
    }
} //아이템 갯수를 리턴처리하면 된다.