package com.binlly.gankee.business.home

import com.binlly.gankee.base.mvp.BaseFragmentPresenter
import com.binlly.gankee.base.mvp.BaseView
import com.binlly.gankee.base.rx.RxObserver


interface HomeContract {
    interface View: BaseView {

    }

    interface Presenter: BaseFragmentPresenter {
        fun requestFeedAll(page: Int, observer: RxObserver<List<FeedAll>?>)
    }
}
