package com.binlly.gankee.business.demo.fragment

import com.binlly.gankee.base.mvp.BaseFragmentPresenter
import com.binlly.gankee.base.mvp.BaseView
import com.binlly.gankee.base.rx.RxObserver
import com.binlly.gankee.business.demo.model.DemoModel

/**
 * Created by yy on 2017/8/25.
 */
interface DemoFragmentContract {
    interface View: BaseView {}

    interface Presenter: BaseFragmentPresenter {
        fun requestDemo(observer: RxObserver<DemoModel>)
        fun requestImageList(observer: RxObserver<DemoFragmentModel>)
    }
}