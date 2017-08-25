package com.binlly.fastpeak.business.demo.activity

import android.content.Context
import android.content.Intent
import com.binlly.fastpeak.base.mvp.BaseActivityPresenterImpl
import com.binlly.fastpeak.base.rx.RxObserver
import com.binlly.fastpeak.business.demo.model.DemoModel
import com.binlly.fastpeak.repo.DemoRepo

/**
 * Created by yy on 2017/8/24.
 */
class DemoPresenter(context: Context,
                    mView: DemoContract.View): BaseActivityPresenterImpl<DemoContract.View>(context,
        mView), DemoContract.Presenter {

    override fun handleIntent(intent: Intent): Boolean {
//        return if (intent.hasExtra("ahah")) {
//            println(intent.getStringExtra("ahah"))
//            true
//        } else {
//            println("没有参数")
//            false
//        }
        return true
    }

    override fun requestDemo(observer: RxObserver<DemoModel>) {
        DemoRepo.requestDemo(observer)
    }
}