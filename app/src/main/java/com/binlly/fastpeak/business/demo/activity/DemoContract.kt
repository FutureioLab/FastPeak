package com.binlly.fastpeak.business.demo.activity

import com.binlly.fastpeak.base.mvp.BaseActivityPresenter
import com.binlly.fastpeak.base.mvp.BaseView
import com.binlly.fastpeak.base.rx.RxObserver
import com.binlly.fastpeak.business.demo.model.DemoModel

/**
 * Created by yy on 2017/8/24.
 */
interface DemoContract {
    interface View: BaseView {

    }

    interface Presenter: BaseActivityPresenter {
        fun requestDemo(observer: RxObserver<DemoModel>)
    }
}