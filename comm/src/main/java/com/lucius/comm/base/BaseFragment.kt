package com.lucius.comm.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initArgs(bundle: Bundle)
    abstract fun initView(view: View)
    abstract fun initData(view: View)
}