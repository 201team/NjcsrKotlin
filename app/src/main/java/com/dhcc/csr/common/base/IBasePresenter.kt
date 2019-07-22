package com.dhcc.csr.common.base

/**
 * @Author: wlsh
 * @Date: 2019/7/19 16:50
 * @Description: Presenter
 */
interface IBasePresenter<in T : IBaseView> {
    fun attachView(view: T)
    fun detachView()
}