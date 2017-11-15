package com.binlly.gankee.business.demo.activity

import android.os.Bundle
import com.binlly.gankee.BuildConfig
import com.binlly.gankee.R
import com.binlly.gankee.base.mvp.BaseMvpActivity
import com.binlly.gankee.base.rx.RxObserver
import com.binlly.gankee.business.demo.fragment.DemoFragmentActivity
import com.binlly.gankee.business.demo.model.DemoModel
import com.binlly.gankee.business.test.TestActivity
import com.binlly.gankee.business.web.WebListActivity
import com.binlly.gankee.tools.MultiClicker
import kotlinx.android.synthetic.main.activity_demo.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class DemoActivity: BaseMvpActivity<DemoPresenter>(), DemoContract.View {

    override fun getContentView(): Int {
        return R.layout.activity_demo
    }

    override fun initView(savedInstanceState: Bundle?) {

        val hit = if (BuildConfig.DEBUG) 2 else 5
        MultiClicker().onMultiClick(hit = hit, view = getToolbar()) {
            startActivity<TestActivity>()
        }

        button_fragment.setOnClickListener { startActivity<DemoFragmentActivity>() }

        button.setOnClickListener { refresh() }

        button_weblist.setOnClickListener { startActivity<WebListActivity>() }
    }

    private fun refresh() {
        P().requestDemo(object: RxObserver<DemoModel>(this) {
            override fun onNext(model: DemoModel) {
                toast(model.toString())
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                e.message ?: return
                toast(e.message.toString())
            }

            override fun onComplete() {
                super.onComplete()
                toast("onComplete")
            }
        })
    }

    override fun isNeedToolbar(): Boolean {
        return true
    }

    override fun customTitle(): String {
        return "Demo"
    }
}
