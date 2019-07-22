package com.dhcc.csr.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dhcc.csr.R
import com.dhcc.csr.util.StatusBarUtil

/**
 * @Author: wlsh
 * @Date: 2019/7/21 15:42
 * @Description: Activity基类(MVP)
 */
abstract class BaseMvpActivity<in V : IBaseView, T : IBasePresenter<V>> : AppCompatActivity(), IBaseView {

    protected var mPresenter: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        //设置状态栏颜色
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimaryDark))
        //初始化Presenter 绑定View
        mPresenter = initPresenter()
        if (mPresenter != null) {
            mPresenter?.attachView(this as V)
        }

        initView(savedInstanceState)
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
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