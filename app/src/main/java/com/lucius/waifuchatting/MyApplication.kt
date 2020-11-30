package com.lucius.waifuchatting

import android.app.Application
import android.content.Context

class MyApplication: Application() {
    companion object {
        var instance: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}