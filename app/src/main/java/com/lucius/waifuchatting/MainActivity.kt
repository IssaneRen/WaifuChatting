package com.lucius.waifuchatting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }


    private fun initView() {
        // 1. 自定义tab的布局
        initTabView()
    }

    // --- start of 底部tabLayout及控制相关

    // private value -- 链接底部tab的adapter
    private val mPagerAdapter = object : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment {
            return Fragment() // 暂时写空fragment
        }

        override fun getCount(): Int {
            return 4 // 暂时写死
        }

        fun getTabView(position: Int): View {
            val view = LayoutInflater.from(this@MainActivity)
                .inflate(R.layout.app_item_main_page_tab, null)
            return view
        }
    }

    private fun initTabView() {
        // 1. 初始化一个 承载首页底部tabLayout的Adapter

        // 2. 利用adapter 重置
        for (i in 0 until mPagerAdapter.count) {
            tab_main_bottom?.newTab()?.let {
                it.customView = mPagerAdapter.getTabView(i)
                if (it.customView != null) {
                    val tabView = it.customView?.parent as View
                    tabView.tag = i
                }
                tab_main_bottom.addTab(it)
            }
        }
    }
    // --- end of 底部tabLayout及控制相关
}