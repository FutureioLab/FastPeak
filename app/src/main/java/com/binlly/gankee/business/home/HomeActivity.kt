package com.binlly.gankee.business.home

import android.os.Bundle
import com.binlly.gankee.R
import com.binlly.gankee.base.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by yy on 2017/11/15.
 */
class HomeActivity: BaseActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_home
    }

    override fun initView(savedInstanceState: Bundle?) {
        val adapter = HomePagerAdapter(supportFragmentManager)
        pager.adapter = adapter
        pager.offscreenPageLimit = 3
        pager.currentItem = 0
    }

    override fun isNeedToolbar(): Boolean {
        return true
    }

    override fun customTitle(): String {
        return "首页"
    }
}