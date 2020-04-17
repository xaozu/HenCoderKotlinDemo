package com.example.lesson.entity

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:37 PM
 * description ：
 **/
data class Lesson(var date: String?, var content: String?, var state: State?) {

    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }
}