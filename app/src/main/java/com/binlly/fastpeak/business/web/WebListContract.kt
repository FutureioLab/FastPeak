package com.binlly.fastpeak.business.web

import com.binlly.fastpeak.base.mvp.BaseActivityPresenter
import com.binlly.fastpeak.base.mvp.BaseView
import com.binlly.fastpeak.base.rx.RxObserver


interface WebListContract {
    interface View: BaseView {
        fun onRefresh(list: List<WebModel>)

        fun onLoadMore(list: List<WebModel>)

        fun loadComplete()

        fun loadEnd()

        fun loadFail()
    }

    interface Presenter: BaseActivityPresenter {
        fun request(observer: RxObserver<WebListModel>)

        fun loadMore(observer: RxObserver<WebListModel>)
    }
}
