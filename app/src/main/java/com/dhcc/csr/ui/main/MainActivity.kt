package com.dhcc.csr.ui.main

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.dhcc.csr.R
import com.dhcc.csr.bean.Item
import com.dhcc.csr.common.base.BaseMvpActivity
import com.dhcc.csr.ui.main.adapter.BrvahAdapter
import com.dhcc.csr.ui.main.contact.MainContact
import com.dhcc.csr.ui.main.presenter.MainPresenterImpl
import com.dhcc.csr.ui.news.NewsActivity
import com.dhcc.csr.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @Author: wlsh
 * @Date: 2019/7/24 9:23
 * @Description: 数据展示页面
 */
class MainActivity : BaseMvpActivity<MainContact.MainView, MainContact.MainPresenter>(), MainContact.MainView {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_C60119))
        rv_list.layoutManager = LinearLayoutManager(this)
    }

    override fun initData() {
        //构造数据
        val dataList = mutableListOf<Item>()
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
        for (i in 1..10 step 1) {
            dataList.add(item)
        }
        //使用kt编写
        //rv_list.adapter = ShowAdapter(this)
        //使用BRVAH编写
        val brvahAdapter = BrvahAdapter(dataList)
        rv_list.adapter = brvahAdapter
        //点击事件
        brvahAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            ToastUtils.showShort("点击了Item $position")
            ActivityUtils.startActivity(NewsActivity::class.java)
        }
        //长按事件
        brvahAdapter.onItemLongClickListener = BaseQuickAdapter.OnItemLongClickListener { adapter, view, position ->
            ToastUtils.showShort("长按了Item $position")
            true
        }
        //开启动画效果
        brvahAdapter.openLoadAnimation()

    }

    override fun initPresenter(): MainContact.MainPresenter {
        return MainPresenterImpl()
    }


}
