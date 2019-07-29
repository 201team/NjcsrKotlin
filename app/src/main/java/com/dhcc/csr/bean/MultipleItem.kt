package com.dhcc.csr.bean

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * @Author: wlsh
 * @Date: 2019/7/25 9:17
 * @Description: 多布局Bean
 */
class MultipleItem(val Type: Int) : MultiItemEntity {

    override fun getItemType(): Int {
        return Type
    }

    companion object {
        val TEXT = 1
        val IMG = 2
        val IMG_TEXT = 3
        val RECYCLEVIEW_DATA = 4
    }
}