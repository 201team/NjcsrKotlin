package com.dhcc.csr.ui.news.adapter

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dhcc.csr.R
import com.dhcc.csr.bean.Item

/**
 * @Author: wlsh
 * @Date: 2019/7/24 15:45
 * @Description:使用BRVAH构建Adapter
 */
class NestAdapter(data: List<Item>) : BaseQuickAdapter<Item, BaseViewHolder>(R.layout.item_show, data) {

    override fun convert(helper: BaseViewHolder, item: Item?) {
        //赋值  设置字体颜色  设置可见  设置背景色或drawable  点击事件
        helper.setText(R.id.txt_matter_status, item?.status)
        helper.setTextColor(R.id.txt_matter_status, ContextCompat.getColor(mContext, R.color.color_FFFFFF))
        helper.setBackgroundColor(R.id.txt_matter_status, ContextCompat.getColor(mContext, R.color.color_C60119))
        helper.setText(R.id.txt_order_code, item?.orderCode)
        helper.setText(R.id.txt_title, item?.title)
        helper.setText(R.id.txt_matter_date, item?.createTime)
        helper.setText(R.id.txt_matter_name, "${item?.traPname}(${item?.tradeptname})")
        //点击事件
        helper.addOnClickListener(R.id.txt_matter_status)
    }
}