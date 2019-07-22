package com.dhcc.csr.ui.login

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dhcc.csr.R
import com.dhcc.csr.common.base.BaseMvpActivity
import com.dhcc.csr.ui.login.contact.LoginContact
import com.dhcc.csr.ui.login.presenter.LoginPresenterImpl
import com.dhcc.csr.util.StatusBarUtil
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @Author: wlsh
 * @Date: 2019/7/21 16:42
 * @Description: 登录
 */
class LoginActivity : BaseMvpActivity<LoginContact.LoginView, LoginContact.LoginPresenter>(), LoginContact.LoginView {

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView(savedInstanceState: Bundle?) {
        Logger.d("initView")
        //设置状态栏颜色
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_FFFFFF))
    }

    override fun initData() {
        Logger.d("initData")
        //登陆操作
        btn_login.setOnClickListener {
            if (mPresenter != null) {
                val name = edt_name.text.toString()
                val pass = edt_pass.text.toString()
                Logger.d("参数:$name $pass")
                mPresenter?.login(name, pass, "1", "我也不知道哈哈哈哈哈")
            }
        }

    }

    override fun initPresenter(): LoginContact.LoginPresenter {
        return LoginPresenterImpl()
    }

    override fun loginSuccess(result: String) {
        Logger.d("登录成功:$result")
    }

    override fun loginFailure() {
        Logger.d("登录失败")
    }

    override fun showLoginDialog() {
        Logger.d("showLoginDialog")
    }

    override fun dismissLoginDialog() {
        Logger.d("dismissLoginDialog")
    }
}
