package com.example.core.http

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:14 PM
 * description ：
 **/
interface EntityCallback<T> {
    fun onSuccess(entity: T)

    fun onFailure(message: String?)
}