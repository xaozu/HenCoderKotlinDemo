package com.example.core.http

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:16 PM
 * description ：
 **/
class HttpClient : OkHttpClient() {
    companion object {
        val INSTANCE = HttpClient()

        private val gson = Gson()

        private fun <T> convert(json: String, type: Type): T {
            return gson.fromJson(json, type)
        }
    }


    operator fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>) {
        val request = Request.Builder()
                .url("https://api.hencoder.com/$path")
                .build()
        val call = INSTANCE.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()!!.string()
                Log.e("HttpClient onResponse ", "body  -> $body")
                when (response.code()) {
                    in 200..299 -> entityCallback.onSuccess(convert(body, type))
                    in 400..499 -> entityCallback.onFailure("客户端错误")
                    in 500..599 -> entityCallback.onFailure("服务器错误")
                    else -> entityCallback.onFailure("未知错误")
                }

            }
        })
    }
}