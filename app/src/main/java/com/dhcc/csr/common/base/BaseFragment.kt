package com.dhcc.csr.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @Author: wlsh
 * @Date: 2019/7/21 16:22
 * @Description:Fragment基类
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contextView: View = inflater.inflate(getLayoutId(), container, false)
        initView(savedInstanceState)
        initData()
        return contextView
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