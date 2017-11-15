package com.binlly.gankee.business.demo.activity

import com.binlly.gankee.base.mvp.BaseActivityPresenter
import com.binlly.gankee.base.mvp.BaseView
import com.binlly.gankee.base.rx.RxObserver
import com.binlly.gankee.business.demo.model.DemoModel

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