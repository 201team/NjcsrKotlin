package com.dhcc.csr.ui.main.presenter

import com.dhcc.csr.ui.main.contact.MainContact

/**
 * @Author: wlsh
 * @Date: 2019/7/24 11:00
 * @Description: 主界面实现类
 */
class MainPresenterImpl : MainContact.MainPresenter {

    private var mView: MainContact.MainView? = null

    override fun attachView(view: MainContact.MainView) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}