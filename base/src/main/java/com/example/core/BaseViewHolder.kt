package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.*

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:30 PM
 * description ：
 **/
@Suppress("UNCHECKED_CAST")
open class BaseViewHolder(var view: View) : ViewHolder(view) {

    private val viewHashMap: MutableMap<Int, View> = HashMap()

     fun <T : View?> getView(@IdRes id: Int): T? {
         return viewHashMap[id]?.apply {
             view.findViewById<T>(id)
         } as T

    }

     fun setText(@IdRes id: Int, text: String?) {
         (getView<View?>(id) as TextView?)?.text = text


    }
}