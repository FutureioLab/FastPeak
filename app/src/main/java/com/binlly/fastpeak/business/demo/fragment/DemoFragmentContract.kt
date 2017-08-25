package com.binlly.fastpeak.business.demo.fragment

import com.binlly.fastpeak.base.mvp.BaseFragmentPresenter
import com.binlly.fastpeak.base.mvp.BaseView
import com.binlly.fastpeak.base.rx.RxObserver
import com.binlly.fastpeak.business.demo.model.DemoModel

/**
 * Created by yy on 2017/8/25.
 */
interface DemoFragmentContract {
    interface View: BaseView {}

    interface Presenter: BaseFragmentPresenter {
        fun requestDemo(observer: RxObserver<DemoModel>)
    }

}