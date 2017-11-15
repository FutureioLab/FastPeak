package com.binlly.gankee.business.home

import com.binlly.gankee.R
import com.binlly.gankee.base.mvp.BaseMvpFragment
import com.binlly.gankee.base.rx.RxObserver

class HomeFragment: BaseMvpFragment<HomePresenter>(), HomeContract.View {

    override fun getContentViewId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        refresh()
    }

    override fun onReload() {
        super.onReload()
        refresh()
    }

    private fun refresh() {
        setPageLoading()
        P.requestFeedAll(0, object: RxObserver<List<FeedAll>?>() {
            override fun onNext(list: List<FeedAll>?) {
                setPageSucceed()
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                setPageError()
            }

            override fun onComplete() {
                super.onComplete()
            }
        })
    }
}
