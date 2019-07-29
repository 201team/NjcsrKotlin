package com.dhcc.csr.ui.news.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ObjectUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dhcc.csr.R
import com.dhcc.csr.bean.Item
import com.dhcc.csr.bean.MultipleItem
import com.orhanobut.logger.Logger

/**
 * @Author: wlsh
 * @Date: 2019/7/25 9:28
 * @Description: 多布局Item
 */
class MultipleItemQuickAdapter(data: List<MultipleItem>) :
    BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>(data), BaseQuickAdapter.OnItemClickListener,
    BaseQuickAdapter.OnItemChildClickListener {

    private lateinit var quickAdapter: NestAdapter
    private var clickListener: ((Item) -> Unit)? = null
    private val dataList = mutableListOf<Item>()

    init {
        addItemType(MultipleItem.IMG, R.layout.item_img)
        addItemType(MultipleItem.TEXT, R.layout.item_show)
        addItemType(MultipleItem.IMG_TEXT, R.layout.item_img_data)
        addItemType(MultipleItem.RECYCLEVIEW_DATA, R.layout.item_rv)
        initData()
    }

    override fun convert(helper: BaseViewHolder, item: MultipleItem?) {
        when (helper.itemViewType) {
            MultipleItem.IMG ->
                helper.addOnClickListener(R.id.img_scenery)
            MultipleItem.TEXT ->
                helper.addOnClickListener(R.id.txt_matter_status)
                    .addOnClickListener(R.id.txt_order_code)
                    .addOnClickListener(R.id.txt_title)
                    .addOnClickListener(R.id.txt_matter_date)
                    .addOnClickListener(R.id.txt_matter_name)
                    .addOnLongClickListener(R.id.txt_matter_status)
            MultipleItem.IMG_TEXT ->
                helper.addOnClickListener(R.id.img_scenery)
                    .addOnClickListener(R.id.txt_hint)
            MultipleItem.RECYCLEVIEW_DATA -> {
                //嵌套RV
                helper.setNestView(R.id.rv_data)
                val recyclerView = helper.getView<RecyclerView>(R.id.rv_data)
                recyclerView.layoutManager = LinearLayoutManager(mContext)
                quickAdapter = NestAdapter(dataList)
                recyclerView.adapter = quickAdapter
                quickAdapter.onItemClickListener = this
                quickAdapter.onItemChildClickListener = this
            }
        }
    }


    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        //区分View
        when (view?.id) {
            R.id.txt_matter_status -> {
                ToastUtils.showShort("点击了单据状态")
                if (ObjectUtils.isNotEmpty(clickListener)) {
                    clickListener?.invoke(dataList[position])
                }
            }
        }
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        Logger.d("嵌套RecycleView item 收到: 点击了第 $position 一次")
        ToastUtils.showShort("点击了嵌套RV $position")
    }

    /**
     * 调用接口
     */
    fun setOnChildClickListener(clickListener: (Item) -> Unit) {
        this.clickListener = clickListener
    }


    /**
     * 构造数据
     */
    private fun initData() {
        dataList.clear()
        val item = Item(
            status = "已办结",
            orderCode = "SXSP2019122323452",
            title = "去北京参加总共第三次代表大会并参与讲话",
            createTime = "2019-12-23 14:21",
            traPname = "湛忠超",
            tradeptname = "技术信息部",
            id = 12442,
            type = "1",
            content = "这是content字段",
            traEndTime = "",
            tradeptCode = "",
            submitTime = "",
            processid = "",
            lastProtime = "",
            lastProname = "",
            destinationName = "",
            destinationCode = "",
            companyName = "",
            companyCode = "",
            closeTime = "",
            tralevelCode = "",
            traleveldesc = "",
            traPcode = "",
            traStartTime = "",
            vehicleId = "",
            vehicleName = "",
            writePcode = "",
            writePname = ""
        )
        for (i in 1..10 step 2) {
            dataList.add(item)
        }
    }
}