package com.lucius.waifuchatting

import androidx.annotation.DrawableRes

class MainPresenter {
    var bottomTabArray: MutableList<HomeTabItem> = ArrayList()
    init {
        // 1. 初始化后首先创建底部四个tab选项
        bottomTabArray.add(HomeTabItem("首页", R.drawable.ic_tab_discover, R.drawable.ic_tab_discover_sel))
        bottomTabArray.add(HomeTabItem("聊天", R.drawable.ic_tab_discover, R.drawable.ic_tab_discover_sel))
        bottomTabArray.add(HomeTabItem("发现", R.drawable.ic_tab_discover, R.drawable.ic_tab_discover_sel))
        bottomTabArray.add(HomeTabItem("我的", R.drawable.ic_tab_discover, R.drawable.ic_tab_discover_sel))
    }

    /**
     * 底部Tab的实体类
     */
    class HomeTabItem(
        var bottomText: String,
        @DrawableRes var iconUnSelected: Int,
        @DrawableRes var iconSelected: Int
    ) {
        var hintNum: Int = 0
        var dotShownFlag: HintDotShownFlag = HintDotShownFlag.NOT_SHOW

        /**
         * 展示红点消息的方式
         */
        enum class HintDotShownFlag {
            NOT_SHOW,   // 不显示红点
            ONLY_DOT,   // 仅显示红点
            WITH_NUM    // 显示红点和数字
        }
    }
}