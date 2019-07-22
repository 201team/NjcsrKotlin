package com.dhcc.csr.ui.login.contact

import com.dhcc.csr.common.base.IBasePresenter
import com.dhcc.csr.common.base.IBaseView

/**
 * @Author: wlsh
 * @Date: 2019/7/21 16:43
 * @Description:登陆契约类
 */
class LoginContact {

    interface LoginView : IBaseView {
        fun loginSuccess(result: String)
        fun loginFailure()
        fun showLoginDialog()
        fun dismissLoginDialog()
    }

    interface LoginPresenter : IBasePresenter<LoginView> {
        fun login(name: String, pass: String, type: String, deviceToken: String)
    }
}