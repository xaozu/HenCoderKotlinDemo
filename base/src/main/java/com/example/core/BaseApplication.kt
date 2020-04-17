package com.example.core

import android.app.Application
import android.content.Context

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:24 PM
 * description ：
 **/
class BaseApplication : Application() {
    companion object{
         lateinit var currentApplication: Context
            private set
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}