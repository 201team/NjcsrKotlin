package com.dhcc.csr.ui.news

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.dhcc.csr.R
import com.dhcc.csr.bean.MultipleItem
import com.dhcc.csr.common.base.BaseActivity
import com.dhcc.csr.ui.news.adapter.MultipleItemQuickAdapter
import com.dhcc.csr.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_news.*

/**
 * @Author: wlsh
 * @Date: 2019/7/25 10:49
 * @Description: 新闻页面
 */
class NewsActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_news
    }

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_C60119))
        rv_multiple.layoutManager = LinearLayoutManager(this)
    }

    override fun initData() {
        val multipleData = mutableListOf<MultipleItem>()
        multipleData.add(MultipleItem(MultipleItem.IMG))
        multipleData.add(MultipleItem(MultipleItem.TEXT))
        multipleData.add(MultipleItem(MultipleItem.IMG))
        multipleData.add(MultipleItem(MultipleItem.IMG_TEXT))
        multipleData.add(MultipleItem(MultipleItem.RECYCLEVIEW_DATA))
        multipleData.add(MultipleItem(MultipleItem.IMG))
        multipleData.add(MultipleItem(MultipleItem.TEXT))
        val multipleAdapter = MultipleItemQuickAdapter(multipleData)

        rv_multiple.adapter = multipleAdapter
        multipleAdapter.openLoadAnimation()
        //单个接口可使用lambda
        multipleAdapter.setOnChildClickListener { item ->
            //嵌套RecycleView的点击事件
            ToastUtils.showShort("点击了单据状态:${item.status}  ${item.orderCode}")
        }
        //内部点击事件
        multipleAdapter.onItemChildClickListener =
            BaseQuickAdapter.OnItemChildClickListener { adapter, view, position ->
                when (view.id) {
                    R.id.img_scenery -> ToastUtils.showShort("点击了图片")
                    R.id.txt_hint -> ToastUtils.showShort("点击了文字提示")
                    R.id.txt_matter_status -> ToastUtils.showShort("点击了单据状态")
                    R.id.txt_order_code -> ToastUtils.showShort("点击了单号")
                    R.id.txt_title -> ToastUtils.showShort("点击了标题")
                    R.id.txt_matter_date -> ToastUtils.showShort("点击了单据日期")
                    R.id.txt_matter_name -> ToastUtils.showShort("点击了起草人名称和部门")
                }
            }
        //内部长按事件
        multipleAdapter.onItemChildLongClickListener =
            BaseQuickAdapter.OnItemChildLongClickListener { adapter, view, position ->
                when (view.id) {
                    R.id.txt_matter_status -> ToastUtils.showShort("长按了单据状态")
                    else -> ToastUtils.showShort("长按了Item")
                }
                true
            }

        //开启动画效果
        multipleAdapter.openLoadAnimation()
    }

}
