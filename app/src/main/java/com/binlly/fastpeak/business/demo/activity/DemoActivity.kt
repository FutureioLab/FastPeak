package com.binlly.fastpeak.business.demo.activity

import android.os.Bundle
import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.mvp.BaseMvpActivity
import com.binlly.fastpeak.base.rx.RxObserver
import com.binlly.fastpeak.business.demo.fragment.DemoFragmentActivity
import com.binlly.fastpeak.business.demo.model.DemoModel
import kotlinx.android.synthetic.main.activity_demo.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class DemoActivity: BaseMvpActivity<DemoPresenter>(), DemoContract.View {

    override fun getContentView(): Int {
        return R.layout.activity_demo
    }

    override fun initView(savedInstanceState: Bundle?) {
        button_fragment.setOnClickListener {
            startActivity<DemoFragmentActivity>()
        }

        button.setOnClickListener {
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
    }
}