package com.kotlintour

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


/**
 * @priject KotlinTour
 * @author LuoXuLiang
 * @description:  应用层 
 * @date: 2017/12/21 上午11:31
 */
class MApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return true
            }
        })
    }
}