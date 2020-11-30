package com.lucius.comm.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        intent?.extras?.let { initArgs(it) }
        initView()
        initData()
    }
    // todo 可以考虑添加一个全局的LoadingView

    @LayoutRes abstract fun getLayoutId():Int
    abstract fun initArgs(bundle: Bundle) // 已经判空，执行到这里一定非空
    abstract fun initView()
    abstract fun initData()
}