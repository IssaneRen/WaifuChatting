package com.lucius.waifuchatting.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucius.comm.base.BaseFragment
import com.lucius.waifuchatting.R

/**
 *
 */
class MeFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.app_fragment_main_me, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MeFragment()
    }
}