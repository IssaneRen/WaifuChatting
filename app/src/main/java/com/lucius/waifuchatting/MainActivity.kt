package com.lucius.waifuchatting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.lucius.comm.base.BaseActivity
import com.lucius.waifuchatting.apputil.id2Color
import com.lucius.waifuchatting.apputil.id2Drawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var mPresenter: MainPresenter = MainPresenter()
    private val initPosition = 0 // 初始的位置 - 不使用常量了

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initArgs(bundle: Bundle) {
    }

    override fun initView() {
        // 1. 自定义tab的布局
        initTabView()
        // 2. 根据tab布局，绑定ViewPager的内容
        initViewPager()
        // 3. 手动设置为正在选择第一项
        setTabSelected(tab_main_bottom?.getTabAt(initPosition), initPosition, true)
    }

    override fun initData() {
    }

    override fun onDestroy() {
        super.onDestroy()
        vp_main_container?.clearOnPageChangeListeners()
    }

    // --- start of 底部tabLayout及控制相关

    // private value -- 链接底部tab的adapter
    private val mPagerAdapter = object : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment {
            return Fragment() // fixme 暂时写空fragment
        }

        override fun getCount(): Int {
            return mPresenter.bottomTabArray.size
        }

        fun getTabView(position: Int): View? {
            val view = LayoutInflater.from(this@MainActivity)?.inflate(R.layout.app_item_main_page_tab, null)
            view?.findViewById<TextView?>(R.id.tv_title)?.text = mPresenter.bottomTabArray[position].bottomText
            view?.findViewById<ImageView?>(R.id.iv_icon)?.setImageDrawable(
                ContextCompat.getDrawable(this@MainActivity, mPresenter.bottomTabArray[position].iconUnSelected)
            )
            return view
        }
    }

    private fun initTabView() {
        for (i in 0 until mPagerAdapter.count) {
            tab_main_bottom?.newTab()?.let { tabBottom ->
                tabBottom.customView = mPagerAdapter.getTabView(i)
                tabBottom.customView?.let {
                    val tabView = it.parent as? View
                    tabView?.tag = i
                    tabView?.setOnClickListener {clickView->
                        val selectPosition = clickView.tag as? Int ?: 0
                        val tab: TabLayout.Tab? = tab_main_bottom.getTabAt(selectPosition)
                        tab?.select()
                        vp_main_container.currentItem = selectPosition
                    }
                }
                tab_main_bottom.addTab(tabBottom)
            }
        }
    }

    private fun initViewPager() {
        vp_main_container?.adapter = mPagerAdapter
        vp_main_container?.offscreenPageLimit = 5
        vp_main_container?.currentItem = initPosition
        vp_main_container?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, offset: Float, offsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                setTabSelected(tab_main_bottom?.getTabAt(position), position, true)
                val count: Int = tab_main_bottom?.tabCount ?: 0
                for (i in 0 until count) {
                    if (i != position) {
                        setTabSelected(tab_main_bottom?.getTabAt(i), i, false)
                    }
                }
            }
        })
    }

    private fun setTabSelected(tab: TabLayout.Tab?, index: Int, selected: Boolean) {
        tab?.customView?.let {
            val tabView = it.parent as View
            val menuIcon = tabView.findViewById<ImageView>(R.id.iv_icon)
            val tvTitle = tabView.findViewById<TextView>(R.id.tv_title)
            menuIcon.setImageDrawable(
                id2Drawable(
                    when (selected) {
                        true -> mPresenter.bottomTabArray[index].iconSelected
                        else -> mPresenter.bottomTabArray[index].iconUnSelected
                    }
                )
            )
            tvTitle.setTextColor(id2Color(if (selected) R.color.waifu_text_selected_1 else R.color.waifu_text_unselected_1))
        }
    }
    // --- end of 底部tabLayout及控制相关
}