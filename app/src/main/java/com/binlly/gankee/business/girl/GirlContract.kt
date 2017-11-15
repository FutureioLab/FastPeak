package com.binlly.gankee.business.girl

import com.binlly.gankee.base.mvp.BaseFragmentPresenter
import com.binlly.gankee.base.mvp.BaseView
import com.binlly.gankee.base.rx.RxObserver


interface GirlContract {
    interface View: BaseView {

    }

    interface Presenter: BaseFragmentPresenter {
        fun requestGirls(observer: RxObserver<List<FeedGirl>?>)
    }
}
