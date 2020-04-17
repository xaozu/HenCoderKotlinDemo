package com.example.core.utils

import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:13 PM
 * description ：
 **/
object CacheUtils {
    private val context = BaseApplication.currentApplication

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) = SP.edit().putString(key, value).apply()

    operator fun get(key: String?) = SP.getString(key, null)

}