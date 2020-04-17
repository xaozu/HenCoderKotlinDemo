package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * author ：zhulunjun
 * email  ：zhulunjun@qq.com
 * date   ：2020/4/17 1:55 PM
 * description ：
 **/
class LessonPresenter(var lessonActivity: LessonActivity) {
    companion object{
        private const val LESSON_PATH = "lessons"
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson>>() {}.type


    fun fetchData() {
        HttpClient.INSTANCE[LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                lessonActivity.runOnUiThread(Runnable { lessonActivity.showResult(entity) })
            }

            override fun onFailure(message: String?) {
                lessonActivity.runOnUiThread(Runnable { toast(message) })
            }
        }]
    }

    fun showPlayback() {
        lessonActivity.showResult(lessons.filter { it.state ===  Lesson.State.PLAYBACK} )
    }



}