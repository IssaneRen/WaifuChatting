package com.lucius.waifuchatting.apputil

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.lucius.waifuchatting.MyApplication


fun id2Drawable(@DrawableRes id: Int): Drawable? {
    MyApplication.instance?.let {
        return ContextCompat.getDrawable(it, id)
    }
    return null
}

@ColorInt
fun id2Color(@ColorRes id: Int): Int {
    MyApplication.instance?.let {
        val result = ContextCompat.getColor(it, id)
        return result
    }
    return -1
}