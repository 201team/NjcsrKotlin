package com.dhcc.csr.common

import android.app.Application
import androidx.annotation.Nullable
import com.dhcc.csr.BuildConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * @Author: wlsh
 * @Date: 2019/7/19 15:58
 * @Description:Application
 */
class App : Application() {

    private val TAG: String = "njcsrAndroid"

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    /**
     * 初始化Logger
     */
    private fun initLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .tag(TAG)
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, @Nullable tag: String?): Boolean {
                //控制log输出
                return BuildConfig.DEBUG
            }
        })
    }
}