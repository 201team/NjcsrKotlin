package com.dhcc.csr.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dhcc.csr.R

/**
 * @Author: wlsh
 * @Date: 2019/7/24 11:28
 * @Description:
 */
class ShowAdapter() : RecyclerView.Adapter<ShowAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    constructor(mContext: Context) : this() {
        this.mContext = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //绑定数据
        holder.txt_title.text = "2019年想休息休息管理体系培训及考试"
        holder.txt_matter_name.text = "湛忠超(技术信息部)"
        holder.txt_matter_status.text = "已办结"
        holder.txt_matter_date.text = "2019-02-11 12:21"
        holder.txt_order_code.text = "SXSP2019021212342"
        holder.txt_matter_status.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_order_code: TextView = itemView.findViewById(R.id.txt_order_code)
        var txt_matter_name: TextView = itemView.findViewById(R.id.txt_matter_name)
        var txt_matter_date: TextView = itemView.findViewById(R.id.txt_matter_date)
        var txt_matter_status: TextView = itemView.findViewById(R.id.txt_matter_status)
        var txt_title: TextView = itemView.findViewById(R.id.txt_title)
    }
}