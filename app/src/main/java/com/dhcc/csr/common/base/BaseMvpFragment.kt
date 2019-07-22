package com.dhcc.csr.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @Author: wlsh
 * @Date: 2019/7/21 16:28
 * @Description: fragment基类(MVP)
 */
abstract class BaseMvpFragment<in V : IBaseView, T : IBasePresenter<V>> : Fragment(), IBaseView {

    protected var mPresenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = initPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mContextView: View = inflater.inflate(getLayoutId(), container, false)
        initView(savedInstanceState)
        initData()
        return mContextView
    }

    @Suppress("UNCHECKED_CAST")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (mPresenter != null) {
            mPresenter?.attachView(this as V)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (mPresenter != null) {
            mPresenter?.detachView()
        }
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

    /**
     * 创建presenter
     */
    protected abstract fun initPresenter(): T
}