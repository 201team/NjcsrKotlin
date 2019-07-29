package com.dhcc.csr.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author: wlsh
 * @Date: 2019/7/19 16:53
 * @Description: Activity基类
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initView(savedInstanceState)
        initData()
    }

    /**
     * 设置布局ID
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int


    /**
     * 初始化View
     */
    protected abstract fun initView(savedInstanceState: Bundle?)


    /**
     * 初始化数据源
     */
    protected abstract fun initData()

}