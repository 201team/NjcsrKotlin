package com.dhcc.csr.ui.login.presenter

import com.dhcc.csr.net.ApiService
import com.dhcc.csr.net.UrlConstant
import com.dhcc.csr.ui.login.contact.LoginContact
import com.orhanobut.logger.Logger
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @Author: wlsh
 * @Date: 2019/7/21 16:46
 * @Description: 登录Presenter实现类
 */
class LoginPresenterImpl : LoginContact.LoginPresenter {

    private var mView: LoginContact.LoginView? = null

    override fun login(name: String, pass: String, type: String, deviceToken: String) {

        mView?.showLoginDialog()

        Logger.d("登陆参数:$name,$pass,$type,$deviceToken")

        val retrofit = Retrofit.Builder()
            .baseUrl(UrlConstant.MAIN_HOST)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        val loginService = retrofit.create(ApiService::class.java)
        val observable = loginService.loginObservable(name, pass, type, deviceToken)
        //通过Observable发起请求
        observable
            .subscribeOn(Schedulers.io())//指定网络请求在io后台线程中进行
            .observeOn(AndroidSchedulers.mainThread())//指定observer回调在UI主线程中进行
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                    Logger.d("onSubscribe")
                }

                override fun onNext(s: String) {
                    Logger.d("onNext$s")
                    if (mView !== null) {
                        val jb = JSONObject(s)
                        when (jb.optString("status")) {
                            "0" -> mView?.loginSuccess(s)
                            "1" -> mView?.loginFailure()
                        }
                        mView?.dismissLoginDialog()
                    }
                }

                override fun onError(e: Throwable) {
                    Logger.d("onError" + e.message)
                    if (mView !== null) {
                        mView?.loginFailure()
                        mView?.dismissLoginDialog()
                    }
                }

                override fun onComplete() {
                    Logger.d("onComplete")
                }
            })

    }

    override fun attachView(view: LoginContact.LoginView) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}