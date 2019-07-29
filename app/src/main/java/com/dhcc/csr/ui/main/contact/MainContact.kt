package com.dhcc.csr.ui.main.contact

import com.dhcc.csr.common.base.IBasePresenter
import com.dhcc.csr.common.base.IBaseView

/**
 * @Author: wlsh
 * @Date: 2019/7/24 10:58
 * @Description: 主界面契约类
 */
class MainContact {
    interface MainView : IBaseView
    interface MainPresenter : IBasePresenter<MainView>
}