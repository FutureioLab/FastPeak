package com.binlly.fastpeak.business.demo.fragment

import android.os.Bundle
import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.mvp.BaseActivity

/**
 * Created by yy on 2017/8/25.
 */
class DemoFragmentActivity: BaseActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_fragment_demo
    }

    override fun initView(savedInstanceState: Bundle?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, DemoFragment()).commit()
    }

    override fun isNeedToolbar(): Boolean {
        return true
    }

    override fun customTitle(): String {
        return "包含Fragment的Activity"
    }
}