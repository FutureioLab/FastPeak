package com.binlly.gankee.business.girl

import com.binlly.gankee.R
import com.binlly.gankee.base.mvp.BaseMvpFragment
import com.binlly.gankee.base.rx.RxObserver

class GirlFragment: BaseMvpFragment<GirlPresenter>(), GirlContract.View {
    override fun getContentViewId(): Int {
        return R.layout.fragment_girl
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
        P.requestGirls(0, object: RxObserver<List<FeedGirl>?>() {
            override fun onNext(list: List<FeedGirl>?) {
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
