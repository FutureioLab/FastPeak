package com.binlly.gankee.business.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.binlly.gankee.business.girl.GirlFragment

/**
 * Created by yy on 2017/11/15.
 */
class HomePagerAdapter(fm: FragmentManager): com.binlly.gankee.base.CacheFragmentStatePagerAdapter(
        fm) {

    private val tabs = arrayOf("首页", "妹子")
    private val fragments = arrayOf(HomeFragment(), GirlFragment())

    override fun createItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabs[position]
    }

    fun tabs(): Array<String> {
        return tabs
    }
}