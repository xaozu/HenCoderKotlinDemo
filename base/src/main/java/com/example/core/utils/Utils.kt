package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:10 PM
 * description ：
 **/

// Float 的扩展函数
// 必须是顶层函数才能这么声明
fun Float.dp2px() : Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Utils.displayMetrics)
}

object Utils {
     val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics


    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) =
            Toast.makeText(BaseApplication.currentApplication, string, duration).show()

}